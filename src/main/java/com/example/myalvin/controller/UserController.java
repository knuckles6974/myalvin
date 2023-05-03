package com.example.myalvin.controller;


import com.example.myalvin.domain.entity.User;
import com.example.myalvin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public String login() {

        return userService.login();
    }

    @PostMapping("/user/signup")
    public String signup() {

        return userService.signup();
    }

    @GetMapping("/user/update/{user_id}")    //해당 유저정보를 가져와 다른 계층에서 처리
    public String updateuser(@PathVariable(name = "user_id") Long user_id) {

        return "";
    }

    @GetMapping("/user/users")
    public String findUsers() {
        return userService.findUsers();
    }


    @DeleteMapping("/user/delete/{user_id}")
    public void deleteuser(@PathVariable(name = "user_id") Long user_id) {

        userService.deleteuser();

    }




}
