package com.hulahoopblue.green.statistics.model.mapper;

import com.hulahoopblue.green.statistics.model.dto.StatisticsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StatisticsMapper {

    // ✅ 두 개의 메서드를 하나로 합치고 @Param 어노테이션을 모두 추가
    List<StatisticsDTO> selectStatisticsByMerchantName(
            @Param("categoryCd") String categoryCd,
            @Param("merchantNm") String merchantNm,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("userMerchantNum") String userMerchantNum);

    List<String> selectCategoryList();

    List<StatisticsDTO> selectMerchantList();
}