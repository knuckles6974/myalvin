package com.example.myalvin.dto;


import com.example.myalvin.domain.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
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

    public Member toMember() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .build();

    }




}
