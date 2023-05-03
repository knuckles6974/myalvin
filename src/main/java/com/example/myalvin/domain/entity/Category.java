package com.example.myalvin.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @OneToOne
    private Chat chat;

    @OneToOne
    private Alarm alarm;

    private String business;

    private String fitness;

    private String health;

    private String life;

    private String other;

}
