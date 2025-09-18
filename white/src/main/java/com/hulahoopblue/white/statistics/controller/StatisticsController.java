package com.hulahoopblue.white.statistics.controller;

import com.hulahoopblue.white.statistics.model.dto.StatisticsDTO;
import com.hulahoopblue.white.statistics.model.service.StatisticsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String statisticsPage(Model model) {
        // 카테고리와 가맹점 목록 전달
        model.addAttribute("categoryList", statisticsService.getCategoryList());
        model.addAttribute("merchantList", statisticsService.getMerchantList());
        return "statistics/statisticsSelect"; // templates/statistics/statisticsSelect.html
    }

    // 통계 조회 (JSON)
    @GetMapping(value = "/list", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<StatisticsDTO> getStatistics(
            @RequestParam(required = false) String categoryCd,
            @RequestParam(required = false) String merchantNum,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        if (startDate == null) startDate = LocalDate.of(2000,1,1);
        if (endDate == null) endDate = LocalDate.now();

        return statisticsService.getStatistics(categoryCd, merchantNum, startDate, endDate);
    }

    // 카테고리 목록 (JSON)
    @GetMapping(value = "/categories", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<String> getCategories() {
        return statisticsService.getCategoryList();
    }

    // 가맹점 목록 (JSON)
    @GetMapping(value = "/merchants", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<StatisticsDTO> getMerchants() {
        return statisticsService.getMerchantList();
    }
}
