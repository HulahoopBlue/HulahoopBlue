package com.hulahoopblue.blue.controller;

import com.hulahoopblue.blue.config.KakaoAPIConfig;
import com.hulahoopblue.blue.model.dto.LoginDTO;
import com.hulahoopblue.blue.model.service.AuthService;
import com.hulahoopblue.blue.model.dto.MemberDTO;
import com.hulahoopblue.blue.model.service.KakaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class AuthController {

    private final KakaoAPIConfig kakaoAPIConfig;
    private final KakaoService kakaoService;
    private final AuthService authService;

    public AuthController(KakaoAPIConfig kakaoAPIConfig, KakaoService kakaoService, AuthService authService) {
        this.kakaoAPIConfig = kakaoAPIConfig;
        this.kakaoService = kakaoService;
        this.authService = authService;
    }

    // 로그인 페이지 - static/index.html 사용
    @GetMapping("/login")

    public String loginPage() {
        return "forward:/index.html";  // static/index.html 보여줌
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(LoginDTO loginDTO, HttpSession session) {
        MemberDTO member = authService.login(loginDTO.getId(), loginDTO.getPw());

        if (member != null) {
            session.setAttribute("loginMember", member);
            session.setMaxInactiveInterval(30 * 60);  // 30분 유지
            session.setAttribute("sessionTimeout", session.getMaxInactiveInterval());
            return "redirect:/blueApplication";
        }

        return "redirect:/login?error"; // 실패 시 index.html 로 돌아감
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";  // 로그아웃 시 루트(index.html)으로
    }

    // 채팅 페이지
    @GetMapping("/blueApplication")
    public String chatDesign(HttpSession session, Model model) {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

        if (loginMember == null) {
            return "redirect:/";
        }

        Integer remainingTime = (Integer) session.getAttribute("sessionTimeout");

        model.addAttribute("kakaoApikey", kakaoAPIConfig.getKakaoApiKey());
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("remainingTime", remainingTime);

        return "/blueApplication";
    }
}
