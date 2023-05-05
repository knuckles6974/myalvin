package com.example.myalvin.domain.entity;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class Aim  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aim_id")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")   //다쪽에 외래키, joincolumn //연관관계주인이 fk로들어온다
    private User user;

    public void changeUser(User user) {
        if (this.user != null) {
            this.user.getAim().remove(this);
        }
        this.user = user;
        user.getAim().add(this);
    }

    private String description;
    private String images;



}
