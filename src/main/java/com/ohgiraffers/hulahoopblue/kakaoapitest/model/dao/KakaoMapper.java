package com.ohgiraffers.hulahoopblue.kakaoapitest.model.dao;

import com.ohgiraffers.hulahoopblue.kakaoapitest.model.dto.KaKaoMapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KakaoMapper {
    List<KaKaoMapDTO> selectAllMarkers();
}
