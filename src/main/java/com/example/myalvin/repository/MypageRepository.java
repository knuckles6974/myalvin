package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Mypage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MypageRepository extends JpaRepository<Mypage, Long> {
}
