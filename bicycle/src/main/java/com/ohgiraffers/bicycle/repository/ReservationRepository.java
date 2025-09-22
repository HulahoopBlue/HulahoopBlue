package com.ohgiraffers.bicycle.repository;

import com.ohgiraffers.bicycle.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // ✅ 사용자 ID로 예약 목록을 조회하는 메서드 추가
    List<Reservation> findByUserId(String userId);
}