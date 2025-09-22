package com.ohgiraffers.travelkidari.service;

import com.ohgiraffers.travelkidari.entity.Reservation;
import com.ohgiraffers.travelkidari.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByUserId(String userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);
        System.out.println("Fetched reservations: " + reservations);
        return reservations;
    }
}