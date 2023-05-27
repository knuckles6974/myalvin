package com.example.myalvin.domain.entity;


import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity(name = "charactor")
@Getter
public class Charactor extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charactor_id")
    private Long id;

    private int level;//글등록시 레벨업

    private String charactor_image; //admin


}
