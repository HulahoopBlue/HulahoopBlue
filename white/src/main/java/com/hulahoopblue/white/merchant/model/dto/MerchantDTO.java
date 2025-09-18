package com.hulahoopblue.white.merchant.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MerchantDTO {
    private String merchantNum;   // 고유 가맹점 식별번호
    private String categoryCd;    // 가맹점 카테고리 코드
    private String merchantNm;    // 가맹점 이름
    private String apiKey;        // 발급 Key
    private String businessNum;   // 사업자 등록 번호
    private LocalDate regDateTime;    // 등록일자
    private LocalDate modifyDateTime; // 수정일자
    private LocalDate endDateTime;    // 종료일자
    private BigDecimal brokerageRate; // 중개수수료율
    private BigDecimal brokerage;     // 중개수수료 금액
    private String contractStatus;    // 계약 상태

    public MerchantDTO() {}

    public MerchantDTO(String merchantNum, String categoryCd, String merchantNm, String apiKey, String businessNum, LocalDate regDateTime, LocalDate modifyDateTime, LocalDate endDateTime, BigDecimal brokerageRate, BigDecimal brokerage, String contractStatus) {
        this.merchantNum = merchantNum;
        this.categoryCd = categoryCd;
        this.merchantNm = merchantNm;
        this.apiKey = apiKey;
        this.businessNum = businessNum;
        this.regDateTime = regDateTime;
        this.modifyDateTime = modifyDateTime;
        this.endDateTime = endDateTime;
        this.brokerageRate = brokerageRate;
        this.brokerage = brokerage;
        this.contractStatus = contractStatus;
    }

    public String getMerchantNum() {
        return merchantNum;
    }

    public void setMerchantNum(String merchantNum) {
        this.merchantNum = merchantNum;
    }

    public String getCategoryCd() {
        return categoryCd;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public String getMerchantNm() {
        return merchantNm;
    }

    public void setMerchantNm(String merchantNm) {
        this.merchantNm = merchantNm;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public LocalDate getRegDateTime() {
        return regDateTime;
    }

    public void setRegDateTime(LocalDate regDateTime) {
        this.regDateTime = regDateTime;
    }

    public LocalDate getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(LocalDate modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    public LocalDate getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDate endDateTime) {
        this.endDateTime = endDateTime;
    }

    public BigDecimal getBrokerageRate() {
        return brokerageRate;
    }

    public void setBrokerageRate(BigDecimal brokerageRate) {
        this.brokerageRate = brokerageRate;
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public String toString() {
        return "MerchantDTO{" +
                "merchantNum='" + merchantNum + '\'' +
                ", categoryCd='" + categoryCd + '\'' +
                ", merchantNm='" + merchantNm + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", businessNum='" + businessNum + '\'' +
                ", regDateTime=" + regDateTime +
                ", modifyDateTime=" + modifyDateTime +
                ", endDateTime=" + endDateTime +
                ", brokerageRate=" + brokerageRate +
                ", brokerage=" + brokerage +
                ", contractStatus='" + contractStatus + '\'' +
                '}';
    }
}