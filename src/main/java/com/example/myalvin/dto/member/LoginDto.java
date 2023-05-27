package com.example.myalvin.dto.member;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @Size(min = 2, max = 50)
    private String email;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;
}