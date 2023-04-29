package com.example.myalvin.entity;

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

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private LocalDateTime time;

}
