package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Charactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactorRepository extends JpaRepository<Charactor, Long> {
}
