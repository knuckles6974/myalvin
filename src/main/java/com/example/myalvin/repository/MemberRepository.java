package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {


    List<Member> findAll();

    Optional<Member> findByEmail(String email);

    Optional<Member> findByPassword(String password);

    Optional<Member> findByEmailAndPassword(String email, String password);

    @Query("SELECT m.password FROM member m WHERE m.email = :email")
    String findPasswordByEmail(@Param("email") String email);

    //List<Member> findAllByName(String name);
}
