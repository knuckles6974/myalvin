package com.example.myalvin.controller;


import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.MemberResponseDto;
import com.example.myalvin.dto.MemberSignupDto;
import com.example.myalvin.service.MemberService;
import com.example.myalvin.validator.MemberValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/member")
public class MemberController {


    private MemberService memberService;
    private MemberValidator memberValidator;

    public MemberController(MemberService memberService, MemberValidator memberValidator) {
        this.memberService = memberService;
        this.memberValidator = memberValidator;
    }
//    @GetMapping("/member/login")
//    public ResponseEntity<String> login() {
//
//        memberService.login();
//        return ResponseEntity.ok().body("token");
//
//    }

    @PostMapping(value = "/signup")
    public MemberResponseDto signup(@RequestBody @Valid MemberSignupDto msdto) {

        Member result =  memberService.signup(msdto);
        return MemberResponseDto.mr(result);
    }

//    @GetMapping("/member/update/{user_id}")    //해당 유저정보를 가져와 다른 계층에서 처리
//    public String updateuser(@PathVariable(name = "user_id") Long user_id) {
//
//        return "";
//    }
//
//    @GetMapping("/user/users")
//    public String findUsers() {
//        return memberService.findUsers();
//    }
//
//
//    @DeleteMapping("/user/delete/{user_id}")
//    public void deleteuser(@PathVariable(name = "user_id") Long user_id) {
//
//        memberService.deleteuser();
//
//    }




}
