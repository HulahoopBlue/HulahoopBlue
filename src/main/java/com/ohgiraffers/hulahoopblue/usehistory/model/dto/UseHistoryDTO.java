package com.ohgiraffers.hulahoopblue.usehistory.model.dto;

import java.util.Date;

public class UseHistoryDTO {

    private String memberNo;
    private String phoneNum;
    private String categoryCode;
    private String merchant;
    private Integer distance;
    private Date paymentDate;
    private Date useStartDate;
    private Date useEndDate;
    private String reservationFlag;

    public UseHistoryDTO() {}

    public UseHistoryDTO(String memberNo, String phoneNum, String categoryCode, String merchant, Integer distince, Date paymentDate, Date useStartDate, Date useEndDate, String reservationFlag) {
        this.memberNo = memberNo;
        this.phoneNum = phoneNum;
        this.categoryCode = categoryCode;
        this.merchant = merchant;
        this.distance = distance;
        this.paymentDate = paymentDate;
        this.useStartDate = useStartDate;
        this.useEndDate = useEndDate;
        this.reservationFlag = reservationFlag;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public void setDistince(Integer distince) {
        this.distance = distance;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setUseStartDate(Date useStartDate) {
        this.useStartDate = useStartDate;
    }

    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }

    public void setReservationFlag(String reservationFlag) {
        this.reservationFlag = reservationFlag;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getMerchant() {
        return merchant;
    }

    public Integer getDistance() {
        return distance;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Date getUseStartDate() {
        return useStartDate;
    }

    public Date getUseEndDate() {
        return useEndDate;
    }

    public String getReservationFlag() {
        return reservationFlag;
    }

    @Override
    public String toString() {
        return "UsageHistoryDTO{" +
                "memberNo='" + memberNo + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", merchant='" + merchant + '\'' +
                ", distance=" + distance +
                ", paymentDate=" + paymentDate +
                ", useStartDate=" + useStartDate +
                ", useEndDate=" + useEndDate +
                ", reservationFlag='" + reservationFlag + '\'' +
                '}';
    }
}
