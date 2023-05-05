package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.User;
import lombok.Data;

@Data
public class ChatDto {

    private Long id;

    private User user;

    private String chat;


}
