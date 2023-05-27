package com.example.myalvin.domain.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import reactor.util.annotation.Nullable;

import javax.persistence.*;


@Entity(name = "aim")
@Getter
public class Aim extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aim_id")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "member_id")   //다쪽에 외래키, joincolumn , 연관관계주인이 fk로들어온다
    private Member member;

    @Nullable
    private String description;

    @Nullable
    private String images;


}
