package com.example.myalvin.domain.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Charactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charactor_id")
    private Long id;

    private int level;//글등록시 레벨업

    private String charactor_image; //admin





}
