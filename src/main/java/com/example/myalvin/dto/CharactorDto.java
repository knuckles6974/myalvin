package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.User;
import lombok.Data;

@Data
public class CharactorDto {
    private Long id;

    private User user;

    private int level;

    private String charactor_image;
}
