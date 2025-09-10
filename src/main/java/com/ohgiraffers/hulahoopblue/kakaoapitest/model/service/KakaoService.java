package com.ohgiraffers.hulahoopblue.kakaoapitest.model.service;

import com.ohgiraffers.hulahoopblue.kakaoapitest.model.dao.KakaoMapper;
import com.ohgiraffers.hulahoopblue.kakaoapitest.model.dto.KaKaoMapDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KakaoService {
    private final KakaoMapper kakaoMapper;

    public KakaoService(KakaoMapper kakaoMapper) {
        this.kakaoMapper = kakaoMapper;
    }

    public List<KaKaoMapDTO> getAllMarkers() {

        return kakaoMapper.selectAllMarkers();
    }
}
