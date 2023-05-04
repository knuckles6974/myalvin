package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Charactor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharactorRepository extends JpaRepository<Charactor, Long> {
}
