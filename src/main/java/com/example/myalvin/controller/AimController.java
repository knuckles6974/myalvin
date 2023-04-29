package com.example.myalvin.controller;



import com.example.myalvin.repository.AimRepository;
import com.example.myalvin.service.AimService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AimController {


    private AimRepository repository;

//    @GetMapping("myalvin/aim")
//    public aimMembers aim() {
//
//        List<UserDto> membersresult = memberRepository.findAll();                     //목표설정한 멤버만
//        List<UserDto>
//
//        return aimMembers;
//
//
//    }









}
