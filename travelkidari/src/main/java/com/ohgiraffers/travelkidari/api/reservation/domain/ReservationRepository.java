package com.ohgiraffers.travelkidari.api.reservation.domain;

import com.ohgiraffers.travelkidari.api.reservation.dto.ReservationViewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT new com.ohgiraffers.travelkidari.api.reservation.dto.ReservationViewDTO(r.reservationNo, u.userId, u.userName, u.userPhone, u.userEmail, r.reservationDateTime, r.reservationStatus) FROM Reservation r JOIN r.user u")
    List<ReservationViewDTO> findAllReservationsWithUserDetails();
}