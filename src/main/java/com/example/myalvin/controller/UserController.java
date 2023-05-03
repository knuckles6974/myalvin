package com.example.myalvin.controller;


import com.example.myalvin.domain.entity.User;
import com.example.myalvin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public String login() {

        return userService.login() ;
    }

    @GetMapping("/user/signup")
    public String signup() {

        return "";
    }

    @GetMapping("/user/update/{user_id}")    //해당 유저정보를 가져와 다른 계층에서 처리
    public String update(@PathVariable(name = "user_id") Long user_id) {

        return "";
    }

//    @GetMapping("/user/users")
//    public List<User> findUsers() {
//        return users;
//    }



}
