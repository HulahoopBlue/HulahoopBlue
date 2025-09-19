package com.hulahoopblue.blue.useHistory.model.service;

import com.hulahoopblue.blue.useHistory.model.dao.UseHistoryMapper;
import com.hulahoopblue.blue.useHistory.model.dto.UseHistoryViewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseHistoryService {
    private final UseHistoryMapper useHistoryMapper;

    public UseHistoryService(UseHistoryMapper useHistoryMapper) {
        this.useHistoryMapper = useHistoryMapper;
    }

    public List<UseHistoryViewDTO> getUseHistory(String memberNum, String categoryCd,String merchantNm, String fromDate, String toDate) {
        return useHistoryMapper.selectUseHistories(memberNum, categoryCd,merchantNm ,fromDate, toDate);
    }
}
