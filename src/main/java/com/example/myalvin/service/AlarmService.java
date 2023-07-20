package com.example.myalvin.service;

import com.example.myalvin.domain.entity.Alarm;
import com.example.myalvin.repository.AlarmRepository;
import com.example.myalvin.repository.AlarmRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlarmService {

    private final AlarmRepository alarmRepository;

    private final AlarmRepositoryImpl alarmRepositoryImpl;

    private final ApplicationEventPublisher applicationEventPublisher;

    private int hour;
    private int minute;
    private int second;

    private String[] day = {"월", "화", "수", "목", "금", "토", "일"};


    public String update_alarm() {
        return null;
    }


    public Alarm create_alarm() {
        System.out.println();
        return null;

    }


    public Optional<Alarm> allalarms(Long member_id) {
        return null;
    }

    public String delete_alarm() {
        return null;
    }


}
