package com.example.myalvin.service;

import com.example.myalvin.config.JwtFilter;
import com.example.myalvin.config.JwtSecurityConfig;
import com.example.myalvin.config.TokenProvider;
import com.example.myalvin.domain.entity.Member;
import com.example.myalvin.dto.TokenDto;
import com.example.myalvin.dto.member.LoginDto;
import com.example.myalvin.dto.member.MemberLoginResponseDto;
import com.example.myalvin.dto.member.MemberSignupDto;
import com.example.myalvin.repository.MemberRepository;
import com.example.myalvin.repository.MemberRepositoryImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.Cookie;
import java.util.Collections;

@Service
public class MemberService implements UserDetailsService {


    private final MemberRepositoryImpl memberRepositoryImpl;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public MemberService(MemberRepositoryImpl memberRepositoryImpl, PasswordEncoder passwordEncoder, TokenProvider tokenProvider, MemberRepository memberRepository, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.memberRepositoryImpl = memberRepositoryImpl;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.memberRepository = memberRepository;
        this.authenticationManagerBuilder = authenticationManagerBuilder;


    }

    @Transactional
    public Member signup(MemberSignupDto msdto) {

        Member member = msdto.toMember();
        member.updatePassword(passwordEncoder.encode(member.getPassword()));
        return memberRepositoryImpl.save(member);
    }


//    public List<Member> findMembers() {
//
//        return memberRepository.findAll();
//
//    }
//
//    public List<Member> findName(String name) {
//
//        return memberRepository.findAll(name);
//    }

    public ResponseEntity<TokenDto> login(LoginDto loginDto) {
        try {
            String email = loginDto.getEmail();
            String password = loginDto.getPassword();

            // 사용자가 입력한 비밀번호를 가져오고 저장된 비밀번호를 가져옵니다.
            String savedPassword = memberRepository.findPasswordByEmail(email);

            // 저장된 비밀번호가 null인 경우 사용자를 찾을 수 없다는 예외를 던집니다.
            if (savedPassword == null) {
                throw new UsernameNotFoundException("User not found");
            }

            // 제공된 비밀번호와 저장된 비밀번호를 비교하여 일치하지 않는 경우 예외를 던집니다.
            if (!passwordEncoder.matches(password, savedPassword)) {
                throw new BadCredentialsException("Incorrect password");
            }

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(email, password);

            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.createToken(authentication);

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

            return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
    }

    public Cookie logout() {
        Cookie cookie = new Cookie(JwtSecurityConfig.AUTHORIZATION_COOKIE, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        return cookie;
    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + memberId));
    }

    public void update(Long id, String name) {

    }

    public Member findByEmail(String email) {
        memberRepository.findByEmail(email);
        return new Member();

    }


//    public Member updateInfo(MemberUpdateInfo memberUpdateInfo) {
//
//        Member memberbyemail = new Member();
//        String email = memberbyemail.getEmail();
//        if (email == null) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
//
//        }
//
//        Member findmember = findByEmail(email);
//        if (memberUpdateInfo.getPassword() != null) {
//            findmember.updatePassword(memberUpdateInfo.getPassword());
//        }
//
//        if (memberUpdateInfo.getEmail() != null) {
//            findmember.updateEmail(memberUpdateInfo.getEmail());
//        }
//
//        if (memberUpdateInfo.getPhone() != null) {
//            findmember.updatePhone(memberUpdateInfo.getPhone());
//        }
//
//        return memberRepository.updateMember(findmember);
//    }
//

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                member.getEmail(),
                member.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

}
