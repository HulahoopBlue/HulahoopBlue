package com.hulahoopblue.blue.useHistory.model.dao;

import com.hulahoopblue.blue.useHistory.model.dto.UseHistoryViewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UseHistoryMapper {

    List<UseHistoryViewDTO> selectUseHistories(String memberNum, String categoryCd,String merchantNm, String fromDate, String toDate);
}
