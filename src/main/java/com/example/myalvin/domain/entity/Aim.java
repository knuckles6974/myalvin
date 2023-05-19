package com.example.myalvin.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Aim {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aim_id")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "member_id")   //다쪽에 외래키, joincolumn , 연관관계주인이 fk로들어온다
    private Member member;

    private String description;

    private String images;



}
