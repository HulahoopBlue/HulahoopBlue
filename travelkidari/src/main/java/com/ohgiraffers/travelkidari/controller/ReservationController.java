package com.ohgiraffers.travelkidari.controller;

import com.ohgiraffers.travelkidari.dto.ReservationRequestDTO;
import com.ohgiraffers.travelkidari.entity.Reservation;
import com.ohgiraffers.travelkidari.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    // ✅ GET API 추가: 사용자 ID로 예약 내역을 조회
    @GetMapping("/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable String userId) {
        try {
            List<Reservation> reservations = reservationService.getReservationsByUserId(userId);
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody ReservationRequestDTO requestDTO) {
        try {
            reservationService.createReservation(requestDTO);
            return ResponseEntity.ok("Reservation created successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An unexpected error occurred.");
        }
    }
}