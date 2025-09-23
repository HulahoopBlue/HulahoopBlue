package com.ohgiraffers.bicycle.dto;

public class ReservationRequestDTO {

    private String phoneNum;
    private String packageName;
    private double paymentAmount;
    private String reservationDateTime;
    private String paymentDateTime;
    private String reservationStatus;

    // 기본 생성자
    public ReservationRequestDTO() {
    }

    // 모든 필드를 포함하는 생성자
    public ReservationRequestDTO(String phoneNum, String packageName, double paymentAmount, String reservationDateTime, String paymentDateTime, String reservationStatus) {
        this.phoneNum = phoneNum;
        this.packageName = packageName;
        this.paymentAmount = paymentAmount;
        this.reservationDateTime = reservationDateTime;
        this.paymentDateTime = paymentDateTime;
        this.reservationStatus = reservationStatus;
    }

    // Getter 메서드
    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPackageName() {
        return packageName;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public String getReservationDateTime() {
        return reservationDateTime;
    }

    public String getPaymentDateTime() {
        return paymentDateTime;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    // Setter 메서드
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setReservationDateTime(String reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public void setPaymentDateTime(String paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}