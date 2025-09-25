package com.hulahoopblue.white.dashboard.controller;

import com.hulahoopblue.white.dashboard.model.dto.DashboardDTO;
import com.hulahoopblue.white.dashboard.model.service.DashboardService;
import com.hulahoopblue.white.member.model.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard/dashboardSelect")
    public String mainPage(HttpSession session, Model model) {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

        if (loginMember == null) {
            return "redirect:/login"; // 세션 없으면 로그인 페이지로
        }

        // 로그인한 사용자와 세션 유지시간 전달
        Integer remainingTime = (Integer) session.getAttribute("sessionTimeout");

        //대시보드 총 이용자 수
        int totalMembers = dashboardService.getTotalMembers();
        //총 가맹점 수
        int totalMerchants = dashboardService.getTotalMerchants();
        //외부 api 접속 건수
        int externalApiCallCount = dashboardService.getExternalApiCallCount();
        //게이트웨이 이용 건수
        int gatewayProcessCount = dashboardService.getGatewayProcessCount();

        model.addAttribute("totalMembers",totalMembers);
        model.addAttribute("totalMerchants",totalMerchants);
        model.addAttribute("externalApiCallCount",externalApiCallCount);
        model.addAttribute("gatewayProcessCount", gatewayProcessCount);
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("remainingTime", remainingTime);

        return "dashboard/dashboardSelect";  // templates/user/main.html
    }

    // 일별 거래금액 API (21~25일 고정)
    @GetMapping("/api/dashboard/brokerageDaily")
    @ResponseBody
    public List<DashboardDTO> getDailyBrokerage() {
        return dashboardService.getDailyBrokerage();
    }

    // 월별 거래금액 API (5월~9월 고정)
    @GetMapping("/api/dashboard/brokerageMonthly")
    @ResponseBody
    public List<DashboardDTO> getMonthlyBrokerage() {
        return dashboardService.getMonthlyBrokerage();
    }

    //동작 체크 대시보드
    @GetMapping("/api/dashboard/status")
    @ResponseBody
    public List<Map<String, Object>> getMerchantStatus() {
        return dashboardService.getMerchantStatus();
    }
}
