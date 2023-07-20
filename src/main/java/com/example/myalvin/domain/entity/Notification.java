package com.example.myalvin.domain.entity;

import com.example.myalvin.util.StringListConvertor;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.ArrayList;
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

    @Convert(converter = StringListConvertor.class)
    private List<String> sounds = new ArrayList<>();

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "alarm_id")
    private Alarm alarm;


}
