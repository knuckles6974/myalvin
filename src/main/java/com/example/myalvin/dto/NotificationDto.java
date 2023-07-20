package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Alarm;
import com.example.myalvin.domain.entity.Notification;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;


@Data
public class NotificationDto {

    private  Long id;

    private final boolean repetition;

    private final List<String> sounds;

    private final Alarm alarm;


    public NotificationDto(boolean repetition, List<String> sounds, Alarm alarm) {

        this.repetition = repetition;
        this.sounds = sounds;
        this.alarm = alarm;


    }

    public static NotificationDto nf( Notification notification){

        return new NotificationDto(
                notification.isRepetition(),
                notification.getSounds(),
                notification.getAlarm()

        );



    }


}
