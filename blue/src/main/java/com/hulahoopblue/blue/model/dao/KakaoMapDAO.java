package com.hulahoopblue.blue.model.dao;

import com.hulahoopblue.blue.model.dto.KaKaoMapDTO;
import com.hulahoopblue.blue.model.dto.UseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KakaoMapDAO {
    List<KaKaoMapDTO> selectAllMarkers();

    int insertUseHistory(UseHistoryDTO dto);
}
