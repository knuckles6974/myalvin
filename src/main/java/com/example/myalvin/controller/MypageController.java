//package com.example.myalvin.controller;
//
//
//import com.example.myalvin.service.MypageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/mypage/")
//public class MypageController {
//
//    @Autowired
//    private MypageService mypageService;
//
//    @GetMapping("/mypage/{user_id}")
//    public String getmypage() {
//
//        return mypageService.getmypage();
//
//
//    }
//
//    @GetMapping("/mypage/update/{user_id}")
//    public String update_mypage(@PathVariable(name = "user_id") Long user_id) {
//
//        return mypageService.update_mypage();
//
//    }
//
//    @DeleteMapping("/mypage/delete/{user_id}")
//    public void delete_mypage() {
//
//        mypageService.delete_mypage();
//    }
//
//
//}
