package com.example.myalvin.domain.entity;


import com.example.myalvin.domain.LevelStatus;
import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "charactor")
@Getter
public class Charactor extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charactor_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private LevelStatus levelstatus;//레벨상태



    private String charactor_image; //admin


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mypage_id")
    private Mypage mypage;

}
