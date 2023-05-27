package com.example.myalvin.dto.member;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MemberLoginRequestDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;


}
