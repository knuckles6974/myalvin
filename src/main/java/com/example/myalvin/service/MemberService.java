package com.example.myalvin.service;

import com.example.myalvin.config.JwtSecurityConfig;
import com.example.myalvin.config.TokenProvider;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.MemberSignupDto;
import com.example.myalvin.dto.MemberUpdateInfo;
import com.example.myalvin.repository.MemberRepository;
import com.example.myalvin.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import java.util.List;

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

    public Member findByEmail(String email) {

        return memberRepository.findByName(email);

    }

    public List<Member> findMembers() {

        return memberRepository.findAll();

    }

    public List<Member> findName(String name) {

        return memberRepository.findByMembers(name);
    }

    public Member updateInfo(MemberUpdateInfo memberUpdateInfo) {

        Member memberbyemail = new Member();
        String email = memberbyemail.getEmail();
        if (email == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");

        }

        Member findmember = findByEmail(email);
        if (memberUpdateInfo.getPassword() != null) {
            findmember.updatePassword(memberUpdateInfo.getPassword());
        }

        if (memberUpdateInfo.getEmail() != null) {
            findmember.updateEmail(memberUpdateInfo.getEmail());
        }

        if (memberUpdateInfo.getPhone() != null) {
            findmember.updatePhone(memberUpdateInfo.getPhone());
        }

        return memberRepository.updateMember(findmember);
    }

    public String login() {
        return "";
    }

    public Cookie logout() {

        Cookie cookie = new Cookie(JwtSecurityConfig.AUTHORIZATION_COOKIE,null);
        cookie.setMaxAge(0);
        return cookie;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
