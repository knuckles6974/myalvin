//package com.example.myalvin.controller;
//
//
//import com.example.myalvin.service.CharactorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/charactor/")
//public class CharactorController {
//
//    @Autowired
//    private CharactorService charactorService;
//
//    @GetMapping("/charactor/{user_id}")
//    public String charac_info(@PathVariable(name = "user_id") Long user_id) {
//
//        return charactorService.charac_info();
//    }
//
//
//
//}
