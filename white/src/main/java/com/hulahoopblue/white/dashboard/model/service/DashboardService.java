package com.hulahoopblue.white.dashboard.model.service;

import com.hulahoopblue.white.dashboard.model.dao.DashboardMapper;
import com.hulahoopblue.white.dashboard.model.dto.DashboardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    private final DashboardMapper dashboardMapper;

    public DashboardService(DashboardMapper dashboardMapper) {
        this.dashboardMapper = dashboardMapper;
    }

    public int getTotalMembers() {

        return dashboardMapper.getTotalMembers();
    }

    public int getTotalMerchants() {

        return dashboardMapper.getTotalMerchants();
    }

    public int getExternalApiCallCount() {

        return dashboardMapper.getExternalApiCallCount();
    }

    public int getGatewayProcessCount() {

        return dashboardMapper.getGatewayProcessCount();
    }

    public List<DashboardDTO> getDailyBrokerage() {

        return dashboardMapper.getDailyBrokerage();
    }

    public List<DashboardDTO> getMonthlyBrokerage() {

        return dashboardMapper.getMonthlyBrokerage();
    }
}
