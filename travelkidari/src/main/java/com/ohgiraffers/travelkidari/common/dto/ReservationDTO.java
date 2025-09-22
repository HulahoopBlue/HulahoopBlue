package com.ohgiraffers.travelkidari.common.dto;

import java.time.LocalDateTime;

public class ReservationDTO {

    private String userId;
    private String userName;
    private String phoneNum;
    private LocalDateTime reservationDateTime;
    private String reservationStatus;
    private Double brokerage;

    public ReservationDTO() {}

    public ReservationDTO(String userId, String userName, String phoneNum, LocalDateTime reservationDateTime, String reservationStatus, Double brokerage) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.reservationDateTime = reservationDateTime;
        this.reservationStatus = reservationStatus;
        this.brokerage = brokerage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", reservationDateTime=" + reservationDateTime +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", brokerage=" + brokerage +
                '}';
    }
}