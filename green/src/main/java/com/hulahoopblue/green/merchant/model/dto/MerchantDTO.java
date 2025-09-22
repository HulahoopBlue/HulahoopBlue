package com.hulahoopblue.green.merchant.model.dto;

import java.sql.Timestamp;

public class MerchantDTO {
    private String categoryCd;
    private String merchantNum;
    private String merchantNm;
    private String apiKey;
    private String businessNum;
    private Timestamp regDateTime;
    private Timestamp modifyDateTime;
    private Timestamp endDateTime;
    private Double brokerageRate;
    private Double brokerage;
    private String contractStatus;


    // Getters and Setters
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

    public Timestamp getRegDateTime() {
        return regDateTime;
    }

    public void setRegDateTime(Timestamp regDateTime) {
        this.regDateTime = regDateTime;
    }

    public Timestamp getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(Timestamp modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
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
}