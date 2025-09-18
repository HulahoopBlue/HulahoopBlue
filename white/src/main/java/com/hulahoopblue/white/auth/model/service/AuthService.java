package com.hulahoopblue.white.auth.model.service;

import com.hulahoopblue.white.member.model.dto.MemberDTO;
import com.hulahoopblue.white.member.model.service.MemberService;
import com.hulahoopblue.white.SHA256Util;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final MemberService memberService;

    public AuthService(MemberService memberService) { this.memberService = memberService; }

    public MemberDTO login(String id, String pw) {
        MemberDTO member = memberService.findById(id);
        if(member == null) return null;

        String encryptedPw = SHA256Util.encrypt(pw);
        if(encryptedPw.equals(member.getPw())) {
            return member;
        }
        return null;
    }
}
