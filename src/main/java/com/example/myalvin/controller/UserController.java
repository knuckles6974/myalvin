package com.example.myalvin.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("myalvin/login")
    public String login() {
        return"login";
    }

    @GetMapping("myalvin/signup")
    public String signup() {
        return "signup";
    }


}
