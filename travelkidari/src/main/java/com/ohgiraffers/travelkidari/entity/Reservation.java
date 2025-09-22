package com.ohgiraffers.travelkidari.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_num")
    private Long transactionNum;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "phone_num", nullable = false)
    private String phoneNum;

    @Column(name = "package_name", nullable = false)
    private String packageName;

    @Column(name = "payment_amount", nullable = true)
    private Double paymentAmount;

    @Column(name = "reservation_date_time", nullable = false)
    private String reservationDateTime;

    @Column(name = "payment_date_time", nullable = true)
    private String paymentDateTime;

    @Column(name = "cancle_date_time", nullable = true)
    private String cancleDateTime;

    @Column(name = "reservation_status", nullable = false)
    private String reservationStatus;

    public Reservation() {}

    // Getter와 Setter에 @JsonProperty 추가
    @JsonProperty("transactionNum")
    public Long getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(Long transactionNum) {
        this.transactionNum = transactionNum;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("phoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @JsonProperty("packageName")
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @JsonProperty("paymentAmount")
    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @JsonProperty("reservationDateTime")
    public String getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(String reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    @JsonProperty("paymentDateTime")
    public String getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(String paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    @JsonProperty("cancleDateTime")
    public String getCancleDateTime() {
        return cancleDateTime;
    }

    public void setCancleDateTime(String cancleDateTime) {
        this.cancleDateTime = cancleDateTime;
    }

    @JsonProperty("reservationStatus")
    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}