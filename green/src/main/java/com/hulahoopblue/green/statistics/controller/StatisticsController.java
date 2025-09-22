package com.hulahoopblue.green.statistics.controller;

import com.hulahoopblue.green.merchant.model.dto.MerchantDTO;
import com.hulahoopblue.green.member.model.dto.MemberDTO;
import com.hulahoopblue.green.statistics.model.dto.StatisticsDTO;
import com.hulahoopblue.green.statistics.model.service.StatisticsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    // 통계 페이지 이동
    @GetMapping("/statisticsSelect")
    public String statisticsPage(Model model, HttpSession session) {
        Object loginObject = session.getAttribute("loginMember");

        if (loginObject == null) {
            return "redirect:/auth/login";
        }

        if (loginObject instanceof MerchantDTO) {
            MerchantDTO loginMerchant = (MerchantDTO) loginObject;
            model.addAttribute("merchantList", List.of(loginMerchant));
        } else {
            model.addAttribute("merchantList", statisticsService.getMerchantList());
        }
        model.addAttribute("categoryList", statisticsService.getCategoryList());
        return "statistics/statisticsSelect";
    }

    // 통계 조회 (JSON)
    @GetMapping(value = "/list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<StatisticsDTO> getStatistics(
            HttpSession session,
            @RequestParam(required = false) String categoryCd,
            @RequestParam(required = false) String merchantNm,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        if (startDate == null) startDate = LocalDate.of(2000, 1, 1);
        if (endDate == null) endDate = LocalDate.now();

        String userMerchantNum = null;

        Object loginObject = session.getAttribute("loginMember");

        // ✅ 로그인 객체가 MemberDTO이고 userTyp이 3(가맹점관리자)일 경우에만 가맹점 번호를 가져옴
        if (loginObject instanceof MemberDTO) {
            MemberDTO loginMember = (MemberDTO) loginObject;
            if (loginMember.getUserTyp() == 3) {
                userMerchantNum = loginMember.getMerchantNum();
                // merchantNm은 쿼리 파라미터로 받은 값이 아닌 MemberDTO의 nm으로 설정
                merchantNm = loginMember.getNm();
            }
        }

        System.out.println("로그인한 가맹점 번호(userMerchantNum): " + userMerchantNum);

        return statisticsService.getStatisticsByMerchantName(categoryCd, merchantNm, startDate, endDate, userMerchantNum);
    }

    @GetMapping
    public String redirectToStatisticsSelect() {
        return "redirect:/statistics/statisticsSelect";
    }

}