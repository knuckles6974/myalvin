package com.example.myalvin.service;

import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.dto.AimDto;
import com.example.myalvin.repository.AimRepository;
import com.example.myalvin.repository.AimRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AimService {

    private final AimRepository aimRepository;

    private final AimRepositoryImpl aimRepositoryImpl;
    public List<Aim> findallaim(int member_id) {


        return aimRepository.findById(member_id);
    }

//    public String update_aim() {
//    }
//
//    public void delete_aim() {
//    }
//
//    public String registeraim(AimDto aim, String memberId) {
//    }
}
