package com.example.myalvin.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 200)
    private String description;
    private LocalDateTime time;

}
