package com.example.myalvin.service;

import com.example.myalvin.domain.entity.Aim;
import com.example.myalvin.repository.AimRepository;
import com.example.myalvin.repository.AimRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AimService {

    private final AimRepository aimRepository;

    private final AimRepositoryImpl aimRepositoryImpl;

    public Optional<Aim> findallaim(Long member_id) {


        return aimRepository.findById(member_id);
    }

    @Transactional
    public Aim registeraim(Aim aim) {

        return aimRepositoryImpl.save(aim);
    }

    public Aim delete_aim(Long member_id) {

        Optional<Aim> aimOptional = aimRepository.findById(member_id);
        if (aimOptional.isPresent()) {
            Aim aim = aimOptional.get();
            aimRepository.deleteById(member_id);
            return aim;

        }

        return null;


    }

    @Transactional
    public void update_aim(Long id, String title , String description, String images) {

        Aim aim = aimRepositoryImpl.findOne(id);
        aim.setTitle(title);
        aim.setDescription(description);
        aim.setImages(images);


    }

    public Optional<Aim> findOne(Long id) {

        return aimRepository.findById(id);
    }
}
