package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Charactor;
import com.example.myalvin.domain.entity.Member;
import lombok.Data;

@Data
public class MypageDto {

    private Long id;

    private Member member;

    private String nickname;

    private Charactor charactor;

    private String introduction;

    private String dailyroutine;
}
