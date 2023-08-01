package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Aim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AimRepository extends JpaRepository<Aim, Long> {

        List<Aim> findById(int member_id);

        Aim deleteById(int member_id);





}
