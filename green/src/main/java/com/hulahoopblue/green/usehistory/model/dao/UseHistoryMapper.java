package com.hulahoopblue.green.usehistory.model.dao;

import com.hulahoopblue.green.usehistory.model.dto.UseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UseHistoryMapper {

    List<UseHistoryDTO> selectUseHistories(
            @Param("merchantNum") String merchantNum,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
