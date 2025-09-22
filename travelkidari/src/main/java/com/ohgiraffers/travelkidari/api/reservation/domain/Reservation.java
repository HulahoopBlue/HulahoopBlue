package com.ohgiraffers.travelkidari.api.reservation.domain;

import com.ohgiraffers.travelkidari.api.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_no")
    private Long reservationNo;

    @ManyToOne
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @Column(name = "reservation_datetime", nullable = false)
    private LocalDateTime reservationDateTime;

    @Column(name = "payment_datetime")
    private LocalDateTime paymentDateTime;

    @Column(name = "reservation_status", nullable = false)
    private String reservationStatus;

    protected Reservation() {}

    public Reservation(User user, LocalDateTime reservationDateTime, LocalDateTime paymentDateTime) {
        this.user = user;
        this.reservationDateTime = reservationDateTime;
        this.paymentDateTime = paymentDateTime;
        this.reservationStatus = "예약대기";
    }

    public Long getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Long reservationNo) {
        this.reservationNo = reservationNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}