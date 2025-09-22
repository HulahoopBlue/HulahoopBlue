package com.hulahoopblue.green.usehistory.controller;

import com.hulahoopblue.green.usehistory.model.dto.UseHistoryDTO;
import com.hulahoopblue.green.usehistory.model.service.UseHistoryService;
import com.hulahoopblue.green.member.model.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/usehistory")
public class UseHistoryController {

    private final UseHistoryService useHistoryService;

    public UseHistoryController(UseHistoryService useHistoryService) {
        this.useHistoryService = useHistoryService;
    }

    // 1️⃣ 이용내역 페이지 (뷰 반환)
    @GetMapping("/usehistorySelect")
    public String useHistoryPage(Model model, HttpSession session) {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

        // ✅ 수정된 부분: instanceof 대신 user_typ을 직접 확인
        if (loginMember != null && loginMember.getUserTyp() == 3) {
            model.addAttribute("merchantNum", loginMember.getMerchantNum());
        } else {
            return "redirect:/auth/login";
        }

        return "usehistory/usehistorySelect";
    }

    // 2️⃣ 이용내역 데이터 조회 (JSON)
    @GetMapping(value = "/list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<UseHistoryDTO> listUseHistory(
            HttpSession session,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
        String merchantNum = null;

        // ✅ 수정된 부분: instanceof 대신 user_typ을 직접 확인
        if (loginMember != null && loginMember.getUserTyp() == 3) {
            merchantNum = loginMember.getMerchantNum();
        } else {
            throw new RuntimeException("가맹점 사용자만 이용할 수 있는 기능입니다.");
        }

        if (startDate == null) startDate = LocalDate.of(2000, 1, 1);
        if (endDate == null) endDate = LocalDate.now();

        return useHistoryService.getUseHistories(merchantNum, startDate, endDate);
    }
}