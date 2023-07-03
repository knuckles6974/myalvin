package com.example.myalvin.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "mypage")
@Getter
@Setter
public class Mypage extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mypage_id")
    private Long id;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 10)
    private String nickname;

    @OneToOne(cascade = CascadeType.ALL)
    private Charactor charactor;

    @Column(length = 100)
    private String introduction;

    @Column(length = 1000)
    private String dailyroutine;







}
