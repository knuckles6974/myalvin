package com.example.myalvin.controller;


import com.example.myalvin.aop.LoginCheck;
import com.example.myalvin.aop.LoginCheck.UserType;
import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.AimDto;
import com.example.myalvin.service.AimService;
import com.example.myalvin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aim")
public class AimController {

    @Autowired
    private AimService aimService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/all/{member_id}")
    @LoginCheck(type = UserType.MEMBER)
    public ResponseEntity<List<AimDto>> findallaims(@PathVariable Long member_id,  HttpServletResponse response) {

        if (memberService.findOne(member_id) == null) {
            Cookie cookie = memberService.logout();
            response.addCookie(cookie);

            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            Optional<Aim> findaim = aimService.findallaim(member_id);
            List<AimDto> collect = findaim.stream()
                    .map(aim -> new AimDto(aim))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(collect, HttpStatus.OK);
        }


    }

    @PostMapping(value = "/post/{member_id}")
    @LoginCheck(type = UserType.MEMBER)
    public ResponseEntity<AimDto> registeraim(@PathVariable("member_id") Long member_id, @RequestBody @Valid Aim aim) {

        Member member = memberService.findOne(member_id);
        if (member == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Set the member of the Aim
        aim.setMember(member);

        Aim result = aimService.registeraim(aim);
        AimDto response = AimDto.postAimDto(result);
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Optional<Aim>> update_aim(@PathVariable("id") Long id, @RequestBody @Valid Aim request) {

        aimService.update_aim(id, request.getTitle(), request.getDescription(), request.getImages());
        Optional<Aim> aim = aimService.findOne(id);

        return new ResponseEntity<>(aim, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{member_id}")
    public void delete_aim(@PathVariable("member_id") Long member_id) {

        aimService.delete_aim(member_id);


    }


}
