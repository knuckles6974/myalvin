package com.example.myalvin.dto;


import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.domain.entity.Chat;
import lombok.Data;

import java.util.List;

@Data
public class MemberDto {

    private Long id;

    private String email;

    private String password;

    public MemberDto(String name) {
        this.name = name;
    }

    private String name;

    private String phone;

    private int follower;

    private int following;

    private List<Aim> aim;

    private List<Chat> chat;




}
