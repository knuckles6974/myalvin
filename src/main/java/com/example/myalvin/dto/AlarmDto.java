package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlarmDto {

    private  Long id;

    private Member member;

    private String description;

    private LocalDateTime time;


}
