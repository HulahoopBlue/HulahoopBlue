package com.hulahoopblue.white.statistics.model.service;

import com.hulahoopblue.white.statistics.model.dao.StatisticsMapper;
import com.hulahoopblue.white.statistics.model.dto.StatisticsDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticsService {

    private final StatisticsMapper statisticsMapper;

    public StatisticsService(StatisticsMapper statisticsMapper) {
        this.statisticsMapper = statisticsMapper;
    }

    public List<StatisticsDTO> getStatistics(String categoryCd, String merchantNum, LocalDate startDate, LocalDate endDate) {
        return statisticsMapper.selectStatistics(categoryCd, merchantNum, startDate, endDate);
    }

    public List<String> getCategoryList() {
        return statisticsMapper.selectCategoryList();
    }

    public List<StatisticsDTO> getMerchantList() {
        return statisticsMapper.selectMerchantList();
    }
}
