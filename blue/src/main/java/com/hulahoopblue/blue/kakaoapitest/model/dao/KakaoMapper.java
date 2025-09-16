package com.hulahoopblue.blue.kakaoapitest.model.dao;

import com.hulahoopblue.blue.kakaoapitest.model.dto.KaKaoMapDTO;
import com.hulahoopblue.blue.kakaoapitest.model.dto.UseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KakaoMapper {
    List<KaKaoMapDTO> selectAllMarkers();

    int insertUseHistory(UseHistoryDTO dto);
}
