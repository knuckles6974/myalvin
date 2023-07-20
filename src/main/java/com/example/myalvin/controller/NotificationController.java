package com.example.myalvin.controller;

import com.example.myalvin.aop.LoginCheck;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.domain.entity.Notification;
import com.example.myalvin.service.MemberService;
import com.example.myalvin.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    private MemberService memberService;


    @GetMapping("/getalarm/{member_id}")
    @LoginCheck(type = LoginCheck.UserType.MEMBER)
    public ResponseEntity<Notification> getalarm(@PathVariable Long member_id) {

        Member member = memberService.findOne(member_id);
        if(member.getId()==null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
        else {
            return new ResponseEntity<>(null,HttpStatus.OK);

        }

    }



}
