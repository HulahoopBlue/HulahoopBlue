package com.hulahoopblue.green.usehistory.model.dto;

import java.time.LocalDateTime;

public class UseHistoryDTO {
    private String transactionNum;
    private String memberNum;
    private String phoneNum;
    private String categoryCd;
    private String merchantNum;
    private String merchantNm; // join으로 가져올 이름
    private Double brokerage;
    private LocalDateTime paymentDateTime;
    private LocalDateTime useStartDateTime;
    private LocalDateTime useEndDateTime;
    private String reservationStatus;

    public UseHistoryDTO() {}

    public UseHistoryDTO(String transactionNum, String memberNum, String phoneNum, String categoryCd, String merchantNum, String merchantNm, Double brokerage, LocalDateTime paymentDateTime, LocalDateTime useStartDateTime, LocalDateTime useEndDateTime, String reservationStatus) {
        this.transactionNum = transactionNum;
        this.memberNum = memberNum;
        this.phoneNum = phoneNum;
        this.categoryCd = categoryCd;
        this.merchantNum = merchantNum;
        this.merchantNm = merchantNm;
        this.brokerage = brokerage;
        this.paymentDateTime = paymentDateTime;
        this.useStartDateTime = useStartDateTime;
        this.useEndDateTime = useEndDateTime;
        this.reservationStatus = reservationStatus;
    }

    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
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

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "UseHistoryDTO{" +
                "transactionNum='" + transactionNum + '\'' +
                ", memberNum='" + memberNum + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", categoryCd='" + categoryCd + '\'' +
                ", merchantNum='" + merchantNum + '\'' +
                ", merchantNm='" + merchantNm + '\'' +
                ", brokerage=" + brokerage +
                ", paymentDateTime=" + paymentDateTime +
                ", useStartDateTime=" + useStartDateTime +
                ", useEndDateTime=" + useEndDateTime +
                ", reservationStatus='" + reservationStatus + '\'' +
                '}';
    }
}
