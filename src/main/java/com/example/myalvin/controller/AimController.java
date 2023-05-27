package com.example.myalvin.controller;


import com.example.myalvin.aop.LoginCheck;
import com.example.myalvin.aop.LoginCheck.UserType;
import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.AimDto;
import com.example.myalvin.service.AimService;
import com.example.myalvin.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aim")
public class AimController {

    @Autowired
    private AimService aimService;

    @GetMapping("/all/{user_id}")
    @LoginCheck(type = UserType.MEMBER)
    public List<AimDto> findallaims(@PathVariable int member_id) {

        List<Aim> findaim = aimService.findallaim(member_id);
        List<AimDto> collect = findaim.stream()
                .map(aim -> new AimDto(aim))
                .collect(Collectors.toList());

        return collect;

    }

//    @PostMapping("/post")
//    @LoginCheck(type = UserType.MEMBER)
//    public void registeraim(@RequestBody AimDto aim, HttpServletRequest request) {
//
//        try {
//            String memberId = MemberUtil.getLoginMemberId(request);
//            if (MemberUtil.isLoggedIn(request) && memberId != null) {
//                aimService.registeraim(aim, memberId);
//
//            } else {
//
//
//
//            }
//        } catch (IllegalStateException e) {
//            MemberUtil.sessionLogout(request);
//
//
//        }
//    }

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
