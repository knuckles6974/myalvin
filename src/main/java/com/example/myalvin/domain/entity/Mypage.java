package com.example.myalvin.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Mypage {

    @Id
    @GeneratedValue
    @Column(name = "mypage_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String nickname;

    private int level;//글등록시 레벨업

    private String introduction;

    private String dailyroutine;

    private String MessageStatus;






}
