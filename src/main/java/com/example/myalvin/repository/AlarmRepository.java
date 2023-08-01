package com.example.myalvin.repository;

import com.example.myalvin.domain.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}
