package com.example.myalvin.domain.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Charactor {
    @Id
    @GeneratedValue
    @Column(name = "charactor_id")
    private Long id;

    @OneToOne(mappedBy = "charactor")
    @JoinColumn(name = "user_id")
    private User user;

    private int level;//글등록시 레벨업

    private String charactor_image; //admin





}
