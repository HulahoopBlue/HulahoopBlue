package com.hulahoopblue.green.statistics.model.service;

import com.hulahoopblue.green.statistics.model.dto.StatisticsDTO;
import com.hulahoopblue.green.statistics.model.mapper.StatisticsMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticsService {

    private final StatisticsMapper statisticsMapper;

    public StatisticsService(StatisticsMapper statisticsMapper) {
        this.statisticsMapper = statisticsMapper;
    }

    public List<StatisticsDTO> getStatisticsByMerchantName(String categoryCd, String merchantNm, LocalDate startDate, LocalDate endDate, String userMerchantNum) {
        return statisticsMapper.selectStatisticsByMerchantName(categoryCd, merchantNm, startDate, endDate, userMerchantNum);
    }

    public List<String> getCategoryList() {
        return statisticsMapper.selectCategoryList();
    }

    public List<StatisticsDTO> getMerchantList() {
        return statisticsMapper.selectMerchantList();
    }
}