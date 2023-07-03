package com.example.myalvin.controller;


import com.example.myalvin.aop.LoginCheck;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.domain.entity.Mypage;
import com.example.myalvin.dto.MypageDto;
import com.example.myalvin.service.MemberService;
import com.example.myalvin.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageService mypageService;

    private MemberService memberService;

    public MypageController(MemberService memberService) {
        this.memberService = memberService;

    }

    @GetMapping("/{member_id}")
    @LoginCheck(type = LoginCheck.UserType.MYPAGE)
    public ResponseEntity<MypageDto> getmypage(@PathVariable Long member_id) {

        Member member = memberService.findOne(member_id);
        if (member == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        } else {
            Mypage mypage = mypageService.getmypage(member_id);
            MypageDto mypageDto = new MypageDto(mypage);

            return new ResponseEntity<>(mypageDto, HttpStatus.OK);
        }


    }


//    @PatchMapping("/update/{member_id}")
//    public void update_mypage() {
//
//        mypageService.update_mypage();
//    }


}
