package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Member;
import lombok.Data;

@Data
public class AimDto {

    private Long id;

    private String title;

    private Member member;

    private String description;

    private String images;

}
