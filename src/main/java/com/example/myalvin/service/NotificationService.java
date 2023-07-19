package com.example.myalvin.service;

import com.example.myalvin.dto.AlarmDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    @EventListener(classes = {AlarmDto.class})
    public void notice(final AlarmDto alarmDto) {




    }
}
