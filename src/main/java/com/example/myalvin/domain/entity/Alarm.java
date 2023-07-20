package com.example.myalvin.domain.entity;

import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "alarm")
@Getter
public class Alarm extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private  Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(mappedBy = "alarm", cascade = CascadeType.ALL)
    private Notification notification;

    @Column(length = 200)
    @Nullable
    private String description;

    private LocalDateTime time;

}
