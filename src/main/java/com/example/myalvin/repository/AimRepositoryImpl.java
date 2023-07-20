package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Aim;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RequiredArgsConstructor
public class AimRepositoryImpl {

    @PersistenceContext
    private final EntityManager em;



    public Aim save(Aim aim) {

        em.persist(aim);

        return aim;
    }

   public Aim findOne(Long id) {

        return em.find(Aim.class, id);

   }
}
