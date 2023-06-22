package com.example.myalvin.dto.member;


import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.domain.entity.Chat;
import com.example.myalvin.domain.entity.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MemberSignupDto {


    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;


    private List<Aim> aim;

    private List<Chat> chat;



    public Member toMember() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .aim(aim)  // aim 필드 설정
                .chat(chat)  // chat 필드 설정
                .build();
    }




}
