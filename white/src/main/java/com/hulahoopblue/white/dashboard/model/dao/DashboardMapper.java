package com.hulahoopblue.white.dashboard.model.dao;

import com.hulahoopblue.white.dashboard.model.dto.DashboardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface DashboardMapper {
    int getTotalMembers();

    int getTotalMerchants();

    int getExternalApiCallCount();

    int getGatewayProcessCount();

    List<DashboardDTO> getDailyBrokerage();

    List<DashboardDTO> getMonthlyBrokerage();

    List<Map<String, Object>> getMerchantStatus();
}
