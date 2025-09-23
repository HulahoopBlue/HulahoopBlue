package com.hulahoopblue.white.dashboard.controller;

import com.hulahoopblue.white.member.model.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard/dashboardSelect")
    public String mainPage(HttpSession session, Model model) {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

        if (loginMember == null) {
            return "redirect:/login"; // 세션 없으면 로그인 페이지로
        }

        // 로그인한 사용자와 세션 유지시간 전달
        Integer remainingTime = (Integer) session.getAttribute("sessionTimeout");

        model.addAttribute("loginMember", loginMember);
        model.addAttribute("remainingTime", remainingTime);

        return "dashboard/dashboardSelect";  // templates/user/main.html
    }
}
