package com.ohgiraffers.travelkidari.api.reservation.dto;

import java.time.LocalDateTime;

public class ReservationViewDTO {
    private Long reservationNo;
    private String userId;
    private String userName;
    private String userPhone;
    private String userEmail;
    private LocalDateTime reservationDateTime;
    private String reservationStatus;

    public ReservationViewDTO(Long reservationNo, String userId, String userName, String userPhone, String userEmail, LocalDateTime reservationDateTime, String reservationStatus) {
        this.reservationNo = reservationNo;
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.reservationDateTime = reservationDateTime;
        this.reservationStatus = reservationStatus;
    }

    // Getters
    public Long getReservationNo() { return reservationNo; }
    public String getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getUserPhone() { return userPhone; }
    public String getUserEmail() { return userEmail; }
    public LocalDateTime getReservationDateTime() { return reservationDateTime; }
    public String getReservationStatus() { return reservationStatus; }
}