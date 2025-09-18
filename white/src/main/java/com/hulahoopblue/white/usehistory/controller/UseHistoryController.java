package com.hulahoopblue.white.usehistory.controller;

import com.hulahoopblue.white.usehistory.model.dto.UseHistoryDTO;
import com.hulahoopblue.white.usehistory.model.service.UseHistoryService;
import com.hulahoopblue.white.merchant.model.dto.MerchantDTO;
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

    // 이용내역 페이지
    @GetMapping("/usehistorySelect")
    public String useHistoryPage(Model model) {
        // 카테고리, 가맹점 목록만 우선 전달
        List<String> categoryList = useHistoryService.getCategoryList();
        List<MerchantDTO> merchantList = useHistoryService.getMerchantList();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("merchantList", merchantList);

        return "usehistory/usehistorySelect"; // templates/usehistory/usehistorySelect.html
    }

    // 이용내역 데이터 조회 (fetch에서 사용)
    @GetMapping(value = "/list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<UseHistoryDTO> listUseHistory(
            String categoryCd,
            String merchantNum,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        if (startDate == null) startDate = LocalDate.of(2000, 1, 1);
        if (endDate == null) endDate = LocalDate.now();

        return useHistoryService.getUseHistories(categoryCd, merchantNum, startDate, endDate);
    }

    // 카테고리 목록 (fetch용)
    @GetMapping(value = "/categories", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<String> categoryList() {
        return useHistoryService.getCategoryList();
    }

    // 가맹점 목록 (fetch용)
    @GetMapping(value = "/merchants", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<MerchantDTO> merchantList() {
        return useHistoryService.getMerchantList();
    }
}
