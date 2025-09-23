package com.hulahoopblue.white.auth.controller;

import com.hulahoopblue.white.auth.model.dto.LoginDTO;
import com.hulahoopblue.white.auth.model.service.AuthService;
import com.hulahoopblue.white.member.model.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "redirect:/index.html";  // static/index.html로 리디렉션
    }


    // 로그인 처리
    @PostMapping("/login")
    public String login(LoginDTO loginDTO, HttpSession session) {
        MemberDTO member = authService.login(loginDTO.getId(), loginDTO.getPw());

        // 로그인 실패 또는 관리자가 아닌 경우
        if(member == null || member.getUserTyp() != 2) {
            return "redirect:/index.html?error=true"; // /index.html로 직접 error=true 전달
        }

        // 관리자 로그인 성공
        session.setAttribute("loginMember", member);
        session.setMaxInactiveInterval(30 * 60); // 세션 30분 유지
        session.setAttribute("sessionTimeout", session.getMaxInactiveInterval()); // 세션 타이머용

        return "redirect:/dashboard/dashboardSelect";
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";  // 기존 /auth/login → /index.html
    }

}
