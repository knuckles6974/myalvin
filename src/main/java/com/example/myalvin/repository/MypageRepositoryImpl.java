package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Mypage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RequiredArgsConstructor
@Repository
public class MypageRepositoryImpl {

    @PersistenceContext
    private final EntityManager em;


    public Mypage save(Mypage mypage) {

        em.persist(mypage);

        return mypage;
    }
}
