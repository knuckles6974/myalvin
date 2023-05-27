package com.example.myalvin.dto.member;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class MemberUpdateInfo {

    private String email;

    private String password;

    private String phone;


}
