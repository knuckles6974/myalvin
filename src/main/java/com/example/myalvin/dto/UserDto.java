package com.example.myalvin.dto;


import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.domain.entity.Chat;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String member_id;

    private String password;

    private String name;

    private String phone;

    private String email;

    private int follower;

    private int following;

    private List<Aim> aim;

    private List<Chat> chat;




}
