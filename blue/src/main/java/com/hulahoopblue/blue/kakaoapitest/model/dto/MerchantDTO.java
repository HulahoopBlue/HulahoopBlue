package com.hulahoopblue.blue.kakaoapitest.model.dto;

import java.time.LocalDate;

public class MerchantDTO {

    private String categoryCd;
    private String merchantNum;    // PK
    private String merchantNm;
    private String apiKey;
    private String businessNum;
    private LocalDate regDateTime;
    private LocalDate modifyDateTime;
    private LocalDate endDateTime;
    private Double brokerageRate;
    private Double brokerage;
    private String contractStatus;

    public MerchantDTO(){}

    public MerchantDTO(String categoryCd, String merchantNum, String merchantNm, String apiKey, String businessNum, LocalDate regDateTime, LocalDate modifyDateTime, LocalDate endDateTime, Double brokerageRate, Double brokerage, String contractStatus) {
        this.categoryCd = categoryCd;
        this.merchantNum = merchantNum;
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

    public Double getBrokerageRate() {
        return brokerageRate;
    }

    public void setBrokerageRate(Double brokerageRate) {
        this.brokerageRate = brokerageRate;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
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
                "categoryCd='" + categoryCd + '\'' +
                ", merchantNum='" + merchantNum + '\'' +
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
