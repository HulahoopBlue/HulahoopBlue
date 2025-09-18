package com.hulahoopblue.white.statistics.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class StatisticsDTO {
    private String categoryCd;
    private String merchantNum;
    private String merchantNm;
    private LocalDate paymentDateTime; // LocalDate로 변경 (시분초 제거)
    private BigDecimal useCnt;
    private BigDecimal useAmt;
    private BigDecimal brokerage;

    public StatisticsDTO() {}

    public StatisticsDTO(String categoryCd, String merchantNum, String merchantNm, LocalDate paymentDateTime, BigDecimal useCnt, BigDecimal useAmt, BigDecimal brokerage) {
        this.categoryCd = categoryCd;
        this.merchantNum = merchantNum;
        this.merchantNm = merchantNm;
        this.paymentDateTime = paymentDateTime;
        this.useCnt = useCnt;
        this.useAmt = useAmt;
        this.brokerage = brokerage;
    }

    public String getCategoryCd() {
        return categoryCd;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public String getMerchantNum() {
        return merchantNum;
    }

    public void setMerchantNum(String merchantNum) {
        this.merchantNum = merchantNum;
    }

    public String getMerchantNm() {
        return merchantNm;
    }

    public void setMerchantNm(String merchantNm) {
        this.merchantNm = merchantNm;
    }

    public LocalDate getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDate paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public BigDecimal getUseCnt() {
        return useCnt;
    }

    public void setUseCnt(BigDecimal useCnt) {
        this.useCnt = useCnt;
    }

    public BigDecimal getUseAmt() {
        return useAmt;
    }

    public void setUseAmt(BigDecimal useAmt) {
        this.useAmt = useAmt;
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    @Override
    public String toString() {
        return "StatisticsDTO{" +
                "categoryCd='" + categoryCd + '\'' +
                ", merchantNum='" + merchantNum + '\'' +
                ", merchantNm='" + merchantNm + '\'' +
                ", paymentDateTime=" + paymentDateTime +
                ", useCnt=" + useCnt +
                ", useAmt=" + useAmt +
                ", brokerage=" + brokerage +
                '}';
    }
}