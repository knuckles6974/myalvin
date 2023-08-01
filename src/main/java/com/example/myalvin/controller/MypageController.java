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

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageService mypageService;

    private MemberService memberService;

    public MypageController(MemberService memberService) {
        this.memberService = memberService;

    }

    @PostMapping(value = "/post/{member_id}")
    @LoginCheck(type = LoginCheck.UserType.MEMBER)
    public ResponseEntity<MypageDto> makemypage(@PathVariable Long member_id, @RequestBody @Valid Mypage mypage) {


        Member member;

        try {
            member = memberService.findOne(member_id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Mypage mid = mypageService.getmypage(member_id);
        if (member.getId() == mid.getId()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }

        mypage.setMember(member);
        Mypage result = mypageService.makemypage(mypage);
        MypageDto mypageDto = new MypageDto(result);
        return new ResponseEntity<>(mypageDto, HttpStatus.CREATED);
    }


    @GetMapping("/{member_id}")
    @LoginCheck(type = LoginCheck.UserType.MEMBER)
    public ResponseEntity<MypageDto> getmypage(@PathVariable Long member_id) {

        Member member = memberService.findOne(member_id);
        if (member.getId() == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        } else {
            Mypage mypage = mypageService.getmypage(member_id);
            MypageDto mypageDto = new MypageDto(mypage);

            return new ResponseEntity<>(mypageDto, HttpStatus.OK);
        }


    }


    @PatchMapping("/update_mypage/{member_id}")
    public ResponseEntity<Mypage> update_mypage(@PathVariable Long member_id) {

        Member member = memberService.findOne(member_id);
        if(member.getId() == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        } else {
            Mypage mypage = mypageService.update_mypage(member_id);
            return new ResponseEntity<>(mypage, HttpStatus.OK);

        }

    }


}
