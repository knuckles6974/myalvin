package com.example.myalvin.domain.entity;


import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private  Long id;

    private String userid;

    private String password;

    private String name;

    private String phone;

    private String email;

    private int follower;

    private int following;

    @OneToMany(mappedBy = "user", fetch = LAZY)//양방향  //읽기전용
    private List<Aim> aim = new ArrayList<>(); //nullpoint

/**
    @OneToMany()
    chat
**/

}
