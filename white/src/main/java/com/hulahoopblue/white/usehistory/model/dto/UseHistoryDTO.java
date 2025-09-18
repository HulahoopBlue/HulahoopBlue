package com.hulahoopblue.white.usehistory.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UseHistoryDTO {
    private int transactionNum;           // 거래번호
    private String memberNum;             // 회원번호
    private String phoneNum;              // 전화번호 (비회원일 경우 기재)
    private String categoryCd;            // 카테고리 코드
    private String merchantNum;           // 가맹점 번호
    private BigDecimal brokerage;               // 이동거리 (m 단위)
    private LocalDateTime paymentDateTime;    // 결제일자
    private LocalDateTime useStartDateTime;   // 이용 시작일자
    private LocalDateTime useEndDateTime;     // 이용 종료일자
    private String reservationStatus;     // 예약상태 (Y:예약중, N:이용완료, C:예약취소)
    private String merchantNm;            // 가맹점 이름 (JOIN 결과)

    public UseHistoryDTO() {}

    public UseHistoryDTO(int transactionNum, String memberNum, String phoneNum, String categoryCd, String merchantNum, BigDecimal brokerage, LocalDateTime paymentDateTime, LocalDateTime useStartDateTime, LocalDateTime useEndDateTime, String reservationStatus, String merchantNm) {
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
        this.merchantNm = merchantNm;
    }

    public int getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(int transactionNum) {
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

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(BigDecimal brokerage) {
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

    public String getMerchantNm() {
        return merchantNm;
    }

    public void setMerchantNm(String merchantNm) {
        this.merchantNm = merchantNm;
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
                ", merchantNm='" + merchantNm + '\'' +
                '}';
    }
}
