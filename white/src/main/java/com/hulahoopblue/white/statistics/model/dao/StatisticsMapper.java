package com.hulahoopblue.white.statistics.model.dao;

import com.hulahoopblue.white.statistics.model.dto.StatisticsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StatisticsMapper {

    // 통계 조회 (일자별, 가맹점별 합계)
    List<StatisticsDTO> selectStatistics(
            @Param("categoryCd") String categoryCd,
            @Param("merchantNum") String merchantNum,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    // 카테고리 목록
    List<String> selectCategoryList();

    // 가맹점 목록 (통계 대상 가맹점만)
    List<StatisticsDTO> selectMerchantList();
}
