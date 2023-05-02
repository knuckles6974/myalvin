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

    private String charactor_image;





}
