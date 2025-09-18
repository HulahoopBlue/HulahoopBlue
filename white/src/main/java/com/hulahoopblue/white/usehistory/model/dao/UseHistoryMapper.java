package com.hulahoopblue.white.usehistory.model.dao;

import com.hulahoopblue.white.merchant.model.dto.MerchantDTO;
import com.hulahoopblue.white.usehistory.model.dto.UseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UseHistoryMapper {
    List<UseHistoryDTO> selectUseHistories(@Param("categoryCd") String categoryCd,
                                           @Param("merchantNum") String merchantNum,
                                           @Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate);

    List<String> selectCategoryList();
    List<MerchantDTO> selectMerchantList();
}

