package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.User;
import lombok.Data;

@Data
public class AimDto {

    private Long id;

    private String title;

    private User user;

    private String description;

    private String images;

}
