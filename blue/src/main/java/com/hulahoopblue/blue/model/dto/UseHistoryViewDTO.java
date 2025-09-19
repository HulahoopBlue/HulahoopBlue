package com.hulahoopblue.blue.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UseHistoryViewDTO {
    private String merchantNm;
    private LocalDateTime useStartDateTime;
    private LocalDateTime useEndDateTime;
    private BigDecimal brokerage;

    public UseHistoryViewDTO(){}

    public UseHistoryViewDTO(String merchantNm, LocalDateTime useStartDateTime, LocalDateTime useEndDateTime, BigDecimal brokerage) {
        this.merchantNm = merchantNm;
        this.useStartDateTime = useStartDateTime;
        this.useEndDateTime = useEndDateTime;
        this.brokerage = brokerage;
    }

    public String getMerchantNm() {
        return merchantNm;
    }

    public void setMerchantNm(String merchantNm) {
        this.merchantNm = merchantNm;
    }

    public LocalDateTime getUseStartDateTime() {
        return useStartDateTime;
    }

    public void setUseStartDateTime(LocalDateTime useStartDateTime) {
        this.useStartDateTime = useStartDateTime;
    }

    public LocalDateTime getUseEndDateTime() {
        return useEndDateTime;
    }

    public void setUseEndDateTime(LocalDateTime useEndDateTime) {
        this.useEndDateTime = useEndDateTime;
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    @Override
    public String toString() {
        return "UseHistoryViewDTO{" +
                "merchantNm='" + merchantNm + '\'' +
                ", useStartDateTime=" + useStartDateTime +
                ", useEndDateTime=" + useEndDateTime +
                ", brokerage=" + brokerage +
                '}';
    }
}
