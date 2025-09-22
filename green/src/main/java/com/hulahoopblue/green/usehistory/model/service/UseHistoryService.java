package com.hulahoopblue.green.usehistory.model.service;

import com.hulahoopblue.green.usehistory.model.dao.UseHistoryMapper;
import com.hulahoopblue.green.usehistory.model.dto.UseHistoryDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UseHistoryService {

    private final UseHistoryMapper useHistoryMapper;

    public UseHistoryService(UseHistoryMapper useHistoryMapper) {
        this.useHistoryMapper = useHistoryMapper;
    }

    // 가맹점 이용내역 조회
    public List<UseHistoryDTO> getUseHistories(String merchantNum, LocalDate startDate, LocalDate endDate) {
        return useHistoryMapper.selectUseHistories(merchantNum, startDate, endDate);
    }
}
