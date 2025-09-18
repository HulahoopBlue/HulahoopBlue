package com.hulahoopblue.white.usehistory.model.service;

import com.hulahoopblue.white.usehistory.model.dao.UseHistoryMapper;
import com.hulahoopblue.white.usehistory.model.dto.UseHistoryDTO;
import com.hulahoopblue.white.merchant.model.dto.MerchantDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UseHistoryService {

    private final UseHistoryMapper useHistoryMapper;

    public UseHistoryService(UseHistoryMapper useHistoryMapper) {
        this.useHistoryMapper = useHistoryMapper;
    }

    // 이용내역 조회
    public List<UseHistoryDTO> getUseHistories(String categoryCd, String merchantNum, LocalDate startDate, LocalDate endDate) {
        return useHistoryMapper.selectUseHistories(categoryCd, merchantNum, startDate, endDate);
    }

    // 카테고리 목록 조회
    public List<String> getCategoryList() {
        return useHistoryMapper.selectCategoryList();
    }

    // 가맹점 목록 조회
    public List<MerchantDTO> getMerchantList() {
        return useHistoryMapper.selectMerchantList();
    }
}
