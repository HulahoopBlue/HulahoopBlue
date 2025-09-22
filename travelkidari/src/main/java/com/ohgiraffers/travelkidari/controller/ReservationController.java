package com.ohgiraffers.travelkidari.controller;

import com.ohgiraffers.travelkidari.entity.Reservation;
import com.ohgiraffers.travelkidari.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/api/reservations")
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation) {
        try {
            reservationService.saveReservation(reservation);
            return ResponseEntity.status(HttpStatus.CREATED).body("예약이 성공적으로 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예약 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/api/reservations/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable String userId) {
        List<Reservation> reservations = reservationService.getReservationsByUserId(userId);
        return ResponseEntity.ok(reservations);
    }
}