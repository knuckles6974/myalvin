package com.example.myalvin.controller;


import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.TokenDto;
import com.example.myalvin.dto.member.*;
import com.example.myalvin.service.MemberService;
import com.example.myalvin.validator.MemberValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/member")
@Slf4j
public class MemberController {


    private MemberService memberService;
    private MemberValidator memberValidator;

    public MemberController(MemberService memberService, MemberValidator memberValidator) {
        this.memberService = memberService;
        this.memberValidator = memberValidator;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) {

        return memberService.login(loginDto);

    }

    @PostMapping(value = "/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody @Valid MemberSignupDto msdto) {
        Member result = memberService.signup(msdto);
        MemberResponseDto response = MemberResponseDto.mr(result);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/email/{email}")
    public Optional<Member> MemberEmail(@PathVariable String email) {

        return memberService.findByEmail(email);


    }

    @GetMapping("/findmembers")
    public List<Member> findAllMember() {
        return memberService.findMembers();


    }

    @GetMapping("/findmember/{name}")
    public List<MemberDto> findNameMember(@PathVariable String name) {
        List<Member> findNameMembers = memberService.findName(name);
        List<MemberDto> collect = findNameMembers.stream()
                .map(m -> new MemberDto(m.getId(),
                        m.getEmail(),
                        m.getPassword(),
                        m.getName(),
                        m.getPhone(),
                        m.getFollower(),
                        m.getFollowing(),
                        m.getAim(),
                        m.getChat()))
                .collect(Collectors.toList());

        return collect;

    }

    @PatchMapping(value = "/changeinfo/{id}")
    public Member.UpdateMemberResponse updateMember(@PathVariable("id") Long id, @RequestBody @Valid Member request) {

        memberService.update(id, request.getEmail(), request.getPassword(), request.getPhone());
        Member putMember = memberService.findOne(id);
        return new Member.UpdateMemberResponse(putMember.getId(), putMember.getEmail(), putMember.getPassword(), putMember.getPhone());

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
