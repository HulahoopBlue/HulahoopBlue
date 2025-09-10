package com.ohgiraffers.hulahoopblue.payment.dao;

import com.ohgiraffers.hulahoopblue.payment.dto.UsageHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsageHistoryMapper {

    // 모든 이용내역 조회
    List<UsageHistoryDTO> findAllUsage();

    // 특정 고객사의 이용내역 조회
    List<UsageHistoryDTO> findUsageByClientId(int clientId);

    // 이용내역 추가
    int insertUsage(UsageHistoryDTO usageHistory);
}
