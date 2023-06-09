package com.example.myalvin.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import reactor.util.annotation.Nullable;

import javax.persistence.*;


@Entity(name = "aim")
@Getter
@Setter
public class Aim extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aim_id")
    private Long id;

    @Column
    private String title;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnoreProperties({"aim", "hibernateLazyInitializer"})//다쪽에 외래키, joincolumn , 연관관계주인이 fk로들어온다
    private Member member;

    public void setMember(Member member) {
        this.member = member;
        member.getAim().add(this);
    }

    @Column
    @Nullable
    private String description;

    @Column
    @Nullable
    private String images;



}
