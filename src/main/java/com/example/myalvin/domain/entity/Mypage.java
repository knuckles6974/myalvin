package com.example.myalvin.domain.entity;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class Mypage {

    @Id
    @GeneratedValue
    @Column(name = "mypage_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String nickname;

    @OneToOne
    private Charactor charactor;

    private String introduction;

    private String dailyroutine;







}
