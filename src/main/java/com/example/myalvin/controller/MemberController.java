package com.example.myalvin.controller;


import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.TokenDto;
import com.example.myalvin.dto.member.LoginDto;
import com.example.myalvin.dto.member.MemberLoginRequestDto;
import com.example.myalvin.dto.member.MemberResponseDto;
import com.example.myalvin.dto.member.MemberSignupDto;
import com.example.myalvin.service.MemberService;
import com.example.myalvin.validator.MemberValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {


    private MemberService memberService;
    private MemberValidator memberValidator;

    public MemberController(MemberService memberService, MemberValidator memberValidator) {
        this.memberService = memberService;
        this.memberValidator = memberValidator;
    }

    @PostMapping(value ="/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) {

            return memberService.login(loginDto);

    }
    @PostMapping(value = "/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody @Valid MemberSignupDto msdto) {
        Member result = memberService.signup(msdto);
        MemberResponseDto response = MemberResponseDto.mr(result);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/email/{memberemail}")
    public Member MemberEmail(@PathVariable String email) {

        Member findMemberByEmail = memberService.findByEmail(email);
        return findMemberByEmail;

    }

//    @GetMapping("/findmembers")
//    public List<MemberDto> findAllMember() {
//        List<Member> findMembers = memberService.findMembers();
//        List<MemberDto> collect = findMembers.stream()
//                .map(m -> new MemberDto(m.getName()))
//                .collect(Collectors.toList());
//
//        return collect;
//    }
//
//    @GetMapping("/name/findmember")
//    public List<MemberDto> findNameMember(@PathVariable String name) {
//        List<Member> findNameMembers = memberService.findName(name);
//        List<MemberDto> collect = findNameMembers.stream()
//                .map(m -> new MemberDto(m.getName()))
//                .collect(Collectors.toList());
//
//        return collect;
//
//    }

    @PutMapping(value = "/changeinfo/{id}")
    public Member.UpdateMemberResponse updateMember(@PathVariable("id") Long id, @RequestBody @Valid Member.UpdateMemberRequest request) {
        memberService.update(id, request.getName());
        Member findMember = memberService.findOne(id);
        return new Member.UpdateMemberResponse(findMember.getId(), findMember.getEmail(), findMember.getPassword(), findMember.getPhone());
    }


    @PostMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = memberService.logout();
        response.addCookie(cookie);

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return HttpStatus.OK.toString();

    }


}
