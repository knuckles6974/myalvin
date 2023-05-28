package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl {

    @PersistenceContext
    private final EntityManager em;

    public Member save(Member member) {

        em.persist(member);

        return member;
    }


    public Member findOne(Long id) {
        return em.find(Member.class, id);


    }

    public List<Member> findAllByName(String name) {
        return em.createQuery("select m from member m where m.name = :name", Member.class).setParameter("name", name)
                .getResultList();
    }
}
