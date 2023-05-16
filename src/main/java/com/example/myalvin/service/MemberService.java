package com.example.myalvin.service;

import com.example.myalvin.config.TokenProvider;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.MemberSignupDto;
import com.example.myalvin.repository.MemberRepository;
import com.example.myalvin.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {


    private final MemberRepositoryImpl memberRepositoryImpl;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final MemberRepository memberRepository;

    @Transactional
    public Member signup(MemberSignupDto msdto) {

        Member member = msdto.toMember();
        member.updatePassword(passwordEncoder.encode(member.getPassword()));
        return memberRepositoryImpl.save(member);
    }



//    public String login() {
//        return "";
//    }
//
//    public String findUsers() {
//    }
//
//
//
//    public void deleteuser() {
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }



}
