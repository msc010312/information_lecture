package com.example.demo.config.auth.scheduled;

import com.example.demo.config.auth.jwt.JwtTokenProvider;
import com.example.demo.config.auth.jwt.KeyGenerator;
import com.example.demo.domain.entity.Signature;
import com.example.demo.domain.repository.SignatureRepository;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
public class SignatureScheduled {
    @Autowired
    private SignatureRepository signatureRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Scheduled(cron = "0 0 * * * *") // 초 분 시 일 월 요일(0-6)
    public void signatureSchedule() {
        List<Signature> list = signatureRepository.findAll();
        byte[] keyBytes = KeyGenerator.getKeygen();
        if (list.isEmpty()) {
            // 최초 시그니처 발급
            jwtTokenProvider.setKey(Keys.hmacShaKeyFor(keyBytes));

            // DB저장
            Signature signature = new Signature();
            signature.setKeyBytes(keyBytes);
            signature.setCreateAt(LocalDate.now());
            signatureRepository.save(signature);
            System.out.println("JwtTokenProvider Constructor  init() Key init : ");
        } else {
            // 서명 값 교체
            signatureRepository.deleteAll();
            Signature signature = new Signature();
            signature.setKeyBytes(keyBytes);
            signature.setCreateAt(LocalDate.now());
            jwtTokenProvider.setKey(Keys.hmacShaKeyFor(keyBytes));
            System.out.println("JwtTokenProvider Constructor init() 기존 키 사용 : ");
        }
    }
}
