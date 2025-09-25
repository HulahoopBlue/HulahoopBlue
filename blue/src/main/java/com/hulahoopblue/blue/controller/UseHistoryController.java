package com.hulahoopblue.blue.controller;

import com.hulahoopblue.blue.model.dto.MemberDTO;
import com.hulahoopblue.blue.model.dto.UseHistoryViewDTO;
import com.hulahoopblue.blue.model.service.UseHistoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class UseHistoryController {

    private final UseHistoryService useHistoryService;

    public UseHistoryController(UseHistoryService useHistoryService) {
        this.useHistoryService = useHistoryService;
    }

    @GetMapping("/useHistory")
    public String useHistory(@RequestParam(required = false) String categoryCd,
                             @RequestParam(required = false) String merchantNm,
                             @RequestParam(required=false) String fromDate,
                             @RequestParam(required=false) String toDate,
                             @RequestParam(required = false) String reservationStatus,
                             HttpSession session,Model model) {

        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
        String memberNum = null;

        if (loginMember != null) {
            memberNum = loginMember.getMemberNum();   // MemberDTO 안에 있는 memberNum 꺼내기
        } else {
            memberNum = "U000000001"; // 디폴트
        }


        List<UseHistoryViewDTO> histories =
                useHistoryService.getUseHistory(memberNum, categoryCd,merchantNm, fromDate,toDate, reservationStatus);

        model.addAttribute("histories", histories);
        model.addAttribute("categoryCd", categoryCd);
        model.addAttribute("merchantNm",merchantNm);
        model.addAttribute("fromDate", fromDate);
        model.addAttribute("toDate", toDate);
        model.addAttribute("reservationStatus", reservationStatus);

        return "useHistory";
    }
}
