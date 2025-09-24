package com.hulahoopblue.white.dashboard.model.dto;

import java.math.BigDecimal;

public class DashboardDTO {
    private String period;
    private BigDecimal total;

    public DashboardDTO(){}

    public DashboardDTO(String period, BigDecimal total) {
        this.period = period;
        this.total = total;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DashboardDTO{" +
                "period='" + period + '\'' +
                ", total=" + total +
                '}';
    }
}
