package com.example.myalvin.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Alarm {

    @Id
    @GeneratedValue
    @Column(name = "alarm_id")
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String description;
    private LocalDateTime time;

}
