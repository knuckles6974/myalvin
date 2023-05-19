package com.example.myalvin.controller;


import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.MemberDto;
import com.example.myalvin.dto.MemberResponseDto;
import com.example.myalvin.dto.MemberSignupDto;
import com.example.myalvin.dto.MemberUpdateInfo;
import com.example.myalvin.service.MemberService;
import com.example.myalvin.validator.MemberValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
public class MemberController {


    private MemberService memberService;
    private MemberValidator memberValidator;

    public MemberController(MemberService memberService, MemberValidator memberValidator) {
        this.memberService = memberService;
        this.memberValidator = memberValidator;
    }
    @PostMapping("/login")
    public void login() {

    }

    @PostMapping(value = "/signup")
    public MemberResponseDto signup(@RequestBody @Valid MemberSignupDto msdto) {

        Member result =  memberService.signup(msdto);
        return MemberResponseDto.mr(result);
    }

    @GetMapping("/email/{memberemail}")
    public Member MemberEmail(@PathVariable String email) {

        Member findMemberByEmail = memberService.findByEmail(email);
        return findMemberByEmail;

    }

    @GetMapping("/findmembers")
    public List<MemberDto> findAllMember() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());

        return collect;
    }

    @GetMapping("/name/findmember")
    public List<MemberDto> findNameMember(@PathVariable String name) {
        List<Member> findNameMembers = memberService.findName(name);
        List<MemberDto> collect = findNameMembers.stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());

        return collect;

    }

    @PutMapping(value = "/changeinfo")
    public Member updateMemberInfo(@RequestBody MemberUpdateInfo memberUpdateInfo) {

        Member result = memberService.updateInfo(memberUpdateInfo);
        return result;

    }

    @PostMapping(value = "/logout")
    public String logout(HttpServletResponse response) {

        Cookie cookie = memberService.logout();
        response.addCookie(cookie);

        return HttpStatus.OK.toString();

    }





//    @DeleteMapping("/user/delete/{user_id}")
//    public void deleteuser(@PathVariable(name = "user_id") Long user_id) {
//
//        memberService.deleteuser();
//
//    }




}
