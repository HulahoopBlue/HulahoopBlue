package com.hulahoopblue.blue.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UseHistoryDTO {

    private int transactionNum;
    private String memberNum;
    private String phoneNum;
    private String categoryCd;
    private String merchantNum;
    private BigDecimal brokerage;
    private LocalDateTime paymentDateTime;
    private LocalDateTime useStartDateTime;
    private LocalDateTime useEndDateTime;
    private String reservationStatus;

    public UseHistoryDTO() {}

    public UseHistoryDTO(int transactionNum, String memberNum, String phoneNum, String categoryCd, String merchantNum, BigDecimal brokerage, LocalDateTime paymentDateTime, LocalDateTime useStartDateTime, LocalDateTime useEndDateTime, String reservationStatus) {
        this.transactionNum = transactionNum;
        this.memberNum = memberNum;
        this.phoneNum = phoneNum;
        this.categoryCd = categoryCd;
        this.merchantNum = merchantNum;
        this.brokerage = brokerage;
        this.paymentDateTime = paymentDateTime;
        this.useStartDateTime = useStartDateTime;
        this.useEndDateTime = useEndDateTime;
        this.reservationStatus = reservationStatus;
    }

    public void setTransactionNum(int transactionNum) {
        this.transactionNum = transactionNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public void setMerchantNum(String merchantNum) {
        this.merchantNum = merchantNum;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public void setUseStartDateTime(LocalDateTime useStartDateTime) {
        this.useStartDateTime = useStartDateTime;
    }

    public void setUseEndDateTime(LocalDateTime useEndDateTime) {
        this.useEndDateTime = useEndDateTime;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public int getTransactionNum() {
        return transactionNum;
    }

    public String getMemberNum() {
        return memberNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getCategoryCd() {
        return categoryCd;
    }

    public String getMerchantNum() {
        return merchantNum;
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public LocalDateTime getUseStartDateTime() {
        return useStartDateTime;
    }

    public LocalDateTime getUseEndDateTime() {
        return useEndDateTime;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    @Override
    public String toString() {
        return "UseHistoryDTO{" +
                "transactionNum=" + transactionNum +
                ", memberNum='" + memberNum + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", categoryCd='" + categoryCd + '\'' +
                ", merchantNum='" + merchantNum + '\'' +
                ", brokerage=" + brokerage +
                ", paymentDateTime=" + paymentDateTime +
                ", useStartDateTime=" + useStartDateTime +
                ", useEndDateTime=" + useEndDateTime +
                ", reservationStatus='" + reservationStatus + '\'' +
                '}';
    }
}