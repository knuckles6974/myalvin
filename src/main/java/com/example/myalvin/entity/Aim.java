package com.example.myalvin.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Aim  {

    @Id @GeneratedValue
    @Column(name = "aim_id")
    private Long id;

    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    private String description;
    private String images;



}
