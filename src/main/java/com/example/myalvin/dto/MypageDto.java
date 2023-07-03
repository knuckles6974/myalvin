package com.example.myalvin.dto;

import com.example.myalvin.domain.entity.Charactor;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.domain.entity.Mypage;
import lombok.Data;

import java.util.Optional;

@Data
public class MypageDto {

    private Long id;

    private Member member;

    private String nickname;

    private Charactor charactor;

    private String introduction;

    private String dailyroutine;

    public MypageDto(Mypage mypage) {
        this.id = mypage.getId();
        this.member = mypage.getMember();
        this.nickname = mypage.getNickname();
        this.charactor = mypage.getCharactor();
        this.introduction = mypage.getIntroduction();
        this.dailyroutine = mypage.getDailyroutine();


    }
}
