package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Member;
import lombok.Data;

import java.util.List;

@Data
public class CharactorDto {
    private Long id;

    private Member member;

    private int level;

    private List<String> charactor_image;
}
