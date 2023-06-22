package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.domain.entity.Member;
import lombok.Data;
import lombok.NonNull;

@Data
public class AimDto {
    private String title;

    private Member member;

    private String description;

    private String images;

    public AimDto(Aim aim) {
        this.title = aim.getTitle();
        this.member = aim.getMember();
        this.description = aim.getDescription();
        this.images = aim.getImages();

    }


    public static AimDto postAimDto(@NonNull Aim aim) {

        return new AimDto(aim);
    }


}
