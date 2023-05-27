package com.example.myalvin.dto.member;


import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.AimDto;
import com.example.myalvin.dto.ChatDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString(exclude = {"follower", "following", "aim", "chat"})
public class MemberResponseDto {

    private final String email;

    private final String password;

    private final String name;

    private final String phone;

    private final int follower;

    private final int following;

    private final List<AimDto> aim;

    private final List<ChatDto> chat;

    public MemberResponseDto(String email, String password, String name, String phone, int follower, int following, List<AimDto> aim, List<ChatDto> chat) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.follower = follower;
        this.following = following;
        this.aim = aim;
        this.chat = chat;

    }

    public static MemberResponseDto mr(@NonNull Member member) {

        List<AimDto> aimDtos = member.getAim().stream()
                .map(aim -> new AimDto(aim))
                .collect(Collectors.toList());
        List<ChatDto> chatDtos = member.getChat().stream()
                .map(chat -> new ChatDto(chat))
                .collect(Collectors.toList());


        return new MemberResponseDto(
                member.getEmail(),
                member.getPassword(),
                member.getName(),
                member.getPhone(),
                member.getFollower(),
                member.getFollowing(),
                aimDtos,
                chatDtos

        );

    }


}
