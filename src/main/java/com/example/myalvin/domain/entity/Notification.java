package com.example.myalvin.domain.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "notification")
@Getter
public class Notification extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    private boolean repetition;

    @ElementCollection
    private List<String> sounds;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="alarm_id")
    private Alarm alarm;





}
