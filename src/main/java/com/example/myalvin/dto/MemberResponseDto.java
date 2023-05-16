package com.example.myalvin.dto;


import com.example.myalvin.domain.entity.Member;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class MemberResponseDto {

    private final String email;

    private final String name;

    public MemberResponseDto(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public static MemberResponseDto mr(@NonNull Member member) {
        return new MemberResponseDto(
                member.getEmail(),
                member.getName()
        );

    }















}
