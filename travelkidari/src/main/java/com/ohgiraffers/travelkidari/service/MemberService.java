package com.ohgiraffers.travelkidari.service;

import com.ohgiraffers.travelkidari.entity.Member;
import com.ohgiraffers.travelkidari.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void save(Member member) {
        // 비밀번호 암호화
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
    }

    public boolean isUserIdExists(String userid) {
        return memberRepository.findByUserid(userid).isPresent();
    }

    // ✅ 로그인 인증 메서드 추가
    public boolean authenticate(String userid, String password) {
        Optional<Member> memberOpt = memberRepository.findByUserid(userid);
        if (memberOpt.isPresent()) {
            Member member = memberOpt.get();
            // 입력된 비밀번호와 DB의 암호화된 비밀번호 비교
            return bCryptPasswordEncoder.matches(password, member.getPassword());
        }
        return false;
    }
}