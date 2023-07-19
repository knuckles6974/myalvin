package com.example.myalvin.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "admin")
public class Admin extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;


    @OneToMany(mappedBy = "admin")
    private List<Member> members = new ArrayList<>();



}
