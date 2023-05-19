package com.example.myalvin.domain.entity;


import jdk.jshell.Snippet;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private  Long id;

    @Column(length = 30, unique = true)
    private String email;

    @Column(length = 50)
    private String password;


    @Column(length = 5)
    private String name;

    @Column(length = 20)
    private String phone;

    @Nullable
    private int follower;

    @Nullable
    private int following;

    @Nullable
    @OneToMany(mappedBy = "member", fetch = LAZY, cascade = CascadeType.ALL )//양방향  //읽기전용
    private List<Aim> aim = new ArrayList<>(); //nullpoint

    @Nullable
    @OneToMany(mappedBy = "member", fetch = LAZY, cascade = CascadeType.PERSIST)
    private List<Chat> chat = new ArrayList<>();

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
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
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

}
