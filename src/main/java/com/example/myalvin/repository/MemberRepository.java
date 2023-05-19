package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {
        Member findByName(String email);
        List<Member> findAll();
        List<Member> findByMembers(String name);
        Member updateMember(Member findmember);

}
