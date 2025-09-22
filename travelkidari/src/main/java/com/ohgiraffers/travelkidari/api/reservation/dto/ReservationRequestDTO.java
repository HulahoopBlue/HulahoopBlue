package com.ohgiraffers.travelkidari.api.reservation.dto;

import java.time.LocalDateTime;

public class ReservationRequestDTO {
    private String phoneNum;
    private LocalDateTime reservationDateTime;
    private LocalDateTime paymentDateTime;

    public ReservationRequestDTO() {}

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

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }
}