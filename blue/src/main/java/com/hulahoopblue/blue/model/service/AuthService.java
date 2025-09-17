package com.hulahoopblue.blue.model.service;

import com.hulahoopblue.blue.model.dto.MemberDTO;
import com.hulahoopblue.blue.model.service.MemberService;
import com.hulahoopblue.blue.SHA256Util;
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
