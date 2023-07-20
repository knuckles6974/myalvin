package com.example.myalvin.domain.entity;


import com.example.myalvin.domain.LevelStatus;
import com.example.myalvin.util.StringListConvertor;
import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "charactor")
@Getter
public class Charactor extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charactor_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private LevelStatus levelstatus;//레벨상태

    @Convert(converter = StringListConvertor.class)
    private List<String> charactor_images = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mypage_id")
    private Mypage mypage;

}
