package com.example.myalvin.dto.member;


import com.example.myalvin.domain.entity.Member;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@Getter
public class MemberLoginResponseDto {

    private final String email;

    private final String password;

    private final String name;



    public MemberLoginResponseDto(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;

    }

    public static MemberLoginResponseDto mlr(@NonNull Member member) {
        return new MemberLoginResponseDto(
                member.getEmail(),
                member.getName(),
                member.getPassword());

    }



}
