package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Chat;
import com.example.myalvin.domain.entity.Member;
import lombok.Data;

@Data
public class ChatDto {

    private Long id;

    private Member member;

    private String chat;

    public ChatDto(Chat chat) {


    }


}
