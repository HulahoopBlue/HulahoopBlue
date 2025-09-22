package com.ohgiraffers.travelkidari.service;

import com.ohgiraffers.travelkidari.dto.ReservationRequestDTO;
import com.ohgiraffers.travelkidari.entity.Member;
import com.ohgiraffers.travelkidari.entity.Reservation;
import com.ohgiraffers.travelkidari.repository.MemberRepository;
import com.ohgiraffers.travelkidari.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
    }

    // 기존에 있던 메서드
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    // 기존에 있던 메서드
    public List<Reservation> getReservationsByUserId(String userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);
        System.out.println("Fetched reservations: " + reservations);
        return reservations;
    }

    // 새롭게 추가된 예약 생성 비즈니스 로직
    public void createReservation(ReservationRequestDTO requestDTO) {
        // 1. 전화번호로 회원 정보 조회
        Optional<Member> memberOptional = memberRepository.findByPhone(requestDTO.getPhoneNum());

        // 2. 전화번호에 해당하는 회원이 없는 경우 예외 처리
        if (memberOptional.isEmpty()) {
            throw new IllegalArgumentException("Phone number not found. Please register first.");
        }

        Member member = memberOptional.get();

        // 3. 예약 엔티티 생성 및 데이터 매핑
        Reservation reservation = new Reservation();
        reservation.setUserId(member.getUserid());
        reservation.setUserName(member.getName());
        reservation.setPhoneNum(requestDTO.getPhoneNum());
        reservation.setPackageName(requestDTO.getPackageName());
        reservation.setPaymentAmount(requestDTO.getPaymentAmount());
        reservation.setReservationDateTime(requestDTO.getReservationDateTime());
        reservation.setPaymentDateTime(requestDTO.getPaymentDateTime());
        reservation.setReservationStatus(requestDTO.getReservationStatus());

        // 4. Repository를 통해 DB에 저장
        reservationRepository.save(reservation);
    }
}