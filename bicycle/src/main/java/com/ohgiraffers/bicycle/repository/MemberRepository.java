package com.ohgiraffers.bicycle.repository;

import com.ohgiraffers.bicycle.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserid(String userid);

    // Member 엔티티의 'phone' 필드에 맞춰 findByPhone으로 수정
    Optional<Member> findByPhone(String phone);
}