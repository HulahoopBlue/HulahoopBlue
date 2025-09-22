package com.hulahoopblue.green.auth.model.service;

import com.hulahoopblue.green.SHA256Util;
import com.hulahoopblue.green.member.model.dto.MemberDTO;
import com.hulahoopblue.green.member.model.service.MemberService;
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
