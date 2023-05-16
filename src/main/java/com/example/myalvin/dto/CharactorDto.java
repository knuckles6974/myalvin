package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Member;
import lombok.Data;

@Data
public class CharactorDto {
    private Long id;

    private Member member;

    private int level;

    private String charactor_image;
}
