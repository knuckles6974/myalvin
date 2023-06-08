package com.example.myalvin.controller;


import com.example.myalvin.aop.LoginCheck;
import com.example.myalvin.aop.LoginCheck.UserType;
import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.AimDto;
import com.example.myalvin.service.AimService;
import com.example.myalvin.service.MemberService;
import com.example.myalvin.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public ResponseEntity<List<AimDto>> findallaims(@PathVariable long member_id, HttpServletRequest request, HttpServletResponse response) {

        if(memberService.findOne(member_id)==null)
        {
            Cookie cookie = memberService.logout();
            response.addCookie(cookie);

            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        else
        {
            Optional<Aim> findaim = aimService.findallaim(member_id);
            List<AimDto> collect = findaim.stream()
                    .map(aim -> new AimDto(aim))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(collect, HttpStatus.OK);
        }


    }

    @PostMapping("/post")
    @LoginCheck(type = UserType.MEMBER)
    public void registeraim(@RequestBody AimDto aim, HttpServletRequest request) {

        


    }

//    @PutMapping(value = "/update/{member_id}")
//    public String update_aim(@PathVariable(name = "member_id") Long member_id) {
//
//        return aimService.update_aim();
//
//    }
//
//    @DeleteMapping("/aim/delete/{user_id}")
//    public void delete_aim(@PathVariable(name = "user_id") Long user_id) {
//
//        aimService.delete_aim();
//    }


}
