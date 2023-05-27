package com.example.myalvin.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class AimRepositoryImpl {

    @PersistenceContext
    private final EntityManager em;



}
