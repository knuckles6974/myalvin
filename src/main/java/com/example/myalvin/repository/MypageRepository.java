package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Mypage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MypageRepository extends JpaRepository<Mypage, Long> {
    Optional<Mypage> findById(int member_id);
}
