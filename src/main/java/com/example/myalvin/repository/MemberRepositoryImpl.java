package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl {

    @PersistenceContext
    private final EntityManager em;

    public Member save(Member member) {

        em.persist(member);
        return member;
    }

}
