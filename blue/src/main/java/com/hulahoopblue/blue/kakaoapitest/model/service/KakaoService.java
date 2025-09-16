package com.hulahoopblue.blue.kakaoapitest.model.service;

import com.hulahoopblue.blue.kakaoapitest.model.dao.KakaoMapper;
import com.hulahoopblue.blue.kakaoapitest.model.dto.KaKaoMapDTO;
import com.hulahoopblue.blue.kakaoapitest.model.dto.UseHistoryDTO;
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

    public int reserveBike(UseHistoryDTO dto) {
        dto.setPaymentDateTime(java.time.LocalDateTime.now());
        dto.setUseStartDateTime(java.time.LocalDateTime.now());
        dto.setUseEndDateTime(null);
        return kakaoMapper.insertUseHistory(dto);
    }
}
