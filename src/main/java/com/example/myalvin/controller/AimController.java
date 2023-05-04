package com.example.myalvin.controller;



import com.example.myalvin.dto.AimDto;
import com.example.myalvin.service.AimService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aim/")
public class AimController {

    @Autowired
    private AimService aimService;

    @GetMapping("/aim/all")
    public String findaims() {

        return aimService.allaim();

    }

    @PostMapping("/aim/post")
    public String post_aim() {

        return aimService.postaim();
    }

    @GetMapping("/aim/update/{user_id}")
    public String update_aim(@PathVariable(name = "user_id") Long user_id) {

        return aimService.update_aim();

    }

    @DeleteMapping("/aim/delete/{user_id}")
    public void delete_aim(@PathVariable(name = "user_id") Long user_id) {

        aimService.delete_aim();
    }





}
