package com.example.myalvin.controller;



import com.example.myalvin.dto.AimDto;
import com.example.myalvin.service.AimService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aim")
public class AimController {

    @Autowired
    private AimService aimService;

    @GetMapping("/aim/all")
    public String findaims() {

        return aimService.allaim();

    }

    @PostMapping("/aim/post")
    public String post() {

        return aimService.postaim();
    }

    @GetMapping("/aim/update/{id}")
    public String update_aim() {

        return aimService.update_aim();

    }

    @DeleteMapping("/aim/delete/{id}")
    public void delete_aim() {

        aimService.delete_aim();
    }





}
