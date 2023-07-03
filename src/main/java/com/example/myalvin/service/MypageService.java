package com.example.myalvin.service;

import com.example.myalvin.domain.entity.Mypage;
import com.example.myalvin.repository.MypageRepository;
import com.example.myalvin.repository.MypageRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MypageService {

    public final MypageRepository mypageRepository;

    public final MypageRepositoryImpl mypageRepositoryimpl;


    public Mypage getmypage(Long member_id) {

        Optional<Mypage> optionalMypage = mypageRepository.findById(member_id);
        return optionalMypage.orElse(null);


    }

//    public String update_mypage() {
//    }
//

}
