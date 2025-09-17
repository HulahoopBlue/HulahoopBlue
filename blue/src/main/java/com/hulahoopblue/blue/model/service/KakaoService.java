package com.hulahoopblue.blue.model.service;

import com.hulahoopblue.blue.model.dao.KakaoMapDAO;
import com.hulahoopblue.blue.model.dto.KaKaoMapDTO;
import com.hulahoopblue.blue.model.dto.UseHistoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KakaoService {
    private final KakaoMapDAO kakaoMapDAO;

    public KakaoService(KakaoMapDAO kakaoMapDAO) {
        this.kakaoMapDAO = kakaoMapDAO;
    }

    public List<KaKaoMapDTO> getAllMarkers() {

        return kakaoMapDAO.selectAllMarkers();
    }

    public int reserveBike(UseHistoryDTO dto) {
        dto.setPaymentDateTime(java.time.LocalDateTime.now());
        dto.setUseStartDateTime(java.time.LocalDateTime.now());
        dto.setUseEndDateTime(null);
        return kakaoMapDAO.insertUseHistory(dto);
    }
}
