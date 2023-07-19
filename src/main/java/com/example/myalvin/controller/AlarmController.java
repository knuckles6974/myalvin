package com.example.myalvin.controller;

import com.example.myalvin.aop.LoginCheck;
import com.example.myalvin.domain.entity.Alarm;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.AlarmDto;
import com.example.myalvin.service.AlarmService;
import com.example.myalvin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alarm")
public class AlarmController {


    @Autowired
    private AlarmService alarmService;

    private MemberService memberService;

    public AlarmController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/alarm/getalarm/{user_id}")
    @LoginCheck(type = LoginCheck.UserType.MEMBER)
    public String update_alarm(@PathVariable Long member_id) {


        return alarmService.update_alarm();
    }

    @PostMapping("/create_alarm")
    @LoginCheck(type = LoginCheck.UserType.MEMBER)
    public ResponseEntity<List<AlarmDto>> create_alarm() {

        List<AlarmDto> collect = alarmService.create_alarm();
        return new ResponseEntity<>(collect, HttpStatus.CREATED);
    }

    @GetMapping("/{member_id}")
    @LoginCheck(type = LoginCheck.UserType.MEMBER)
    public ResponseEntity<List<AlarmDto>> all_alarms(@PathVariable Long member_id) {

        Member member = memberService.findOne(member_id);
        if (member == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        } else {
            Optional<Alarm> findalarm = alarmService.allalarms(member_id);
            List<AlarmDto> collect = findalarm.stream()
                    .map(m -> new AlarmDto())
                    .collect(Collectors.toList());
            return new ResponseEntity<>(collect, HttpStatus.OK);

        }


    }

    @DeleteMapping("/alarm/delete/{user_id}")
    @LoginCheck(type = LoginCheck.UserType.MEMBER)
    public void delete_alarm(@PathVariable Long Member_id) {

        alarmService.delete_alarm();
    }


}
