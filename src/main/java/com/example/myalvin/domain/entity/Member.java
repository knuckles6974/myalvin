package com.example.myalvin.domain.entity;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

import static javax.persistence.FetchType.LAZY;


@Entity(name = "member")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "member")
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 30, unique = true)
    private String email;

    @Column
    private String password;


    @Column(length = 5)
    private String name;

    @Column(length = 20)
    private String phone;

    private int follower;

    private int following;

    @OneToMany(mappedBy = "member", fetch = LAZY, cascade = CascadeType.ALL)//양방향  //읽기전용
    private List<Aim> aim = new ArrayList<>(); //nullpoint


    @OneToMany(mappedBy = "member", fetch = LAZY, cascade = CascadeType.PERSIST)
    private List<Chat> chat = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Builder
    public Member(Long id, @NonNull String email, @NonNull String password, String name, String phone, int follower, int following) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.follower = follower;
        this.following = following;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Use SimpleGrantedAuthority to create authorities/roles for the user.
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Account is not expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        return true;  // Account is enabled
    }
    public void updatePassword(String password) {
        this.password = password;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    @Data
    public static class UpdateMemberRequest {
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class UpdateMemberResponse {
        private Long id;
        private String email;
        private String password;
        private String phone;


    }


}
