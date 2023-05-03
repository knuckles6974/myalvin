package com.example.myalvin.domain.entity;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class Chat {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String chat;

}
