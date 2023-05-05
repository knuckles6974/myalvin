package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlarmDto {

    private  Long id;

    private User user;

    private String description;

    private LocalDateTime time;


}
