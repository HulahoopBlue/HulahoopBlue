package com.ohgiraffers.travelkidari.controller;

import com.ohgiraffers.travelkidari.entity.Member;
import com.ohgiraffers.travelkidari.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/signup")
    public ResponseEntity<String> signup(@RequestBody Member member) {
        if (memberService.isUserIdExists(member.getUserid())) {
            return ResponseEntity.badRequest().body("이미 존재하는 아이디입니다.");
        }
        memberService.save(member);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    // ✅ 로그인 API 추가
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody Member member) {
        if (memberService.authenticate(member.getUserid(), member.getPassword())) {
            return ResponseEntity.ok(member.getUserid());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
    }
}