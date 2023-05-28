package com.example.myalvin.dto.member;


import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.domain.entity.Chat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class MemberDto {

    private Long id;

    private String email;

    private String password;

    private String name;


    private String phone;

    private int follower;

    private int following;

    private List<Aim> aim;

    private List<Chat> chat;


}
