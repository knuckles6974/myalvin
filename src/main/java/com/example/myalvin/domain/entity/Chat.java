package com.example.myalvin.domain.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Chat {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String chat;

}
