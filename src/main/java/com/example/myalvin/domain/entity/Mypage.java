package com.example.myalvin.domain.entity;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class Mypage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mypage_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 10)
    private String nickname;

    @OneToOne
    private Charactor charactor;

    @Column(length = 100)
    private String introduction;

    @Column(length = 1000)
    private String dailyroutine;







}
