package com.ohgiraffers.travelkidari.api.user.service;

import com.ohgiraffers.travelkidari.api.user.domain.User;
import com.ohgiraffers.travelkidari.api.user.domain.UserRepository;
import com.ohgiraffers.travelkidari.api.user.dto.UserRequestDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getUserId() == null || userRequestDTO.getUserId().trim().isEmpty()) {
            throw new IllegalArgumentException("아이디는 필수 입력값입니다.");
        }
        if (userRequestDTO.getUserPassword() == null || userRequestDTO.getUserPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("비밀번호는 필수 입력값입니다.");
        }

        Optional<User> existingUser = userRepository.findByUserId(userRequestDTO.getUserId());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        String userEmail = (userRequestDTO.getUserEmail() != null) ? userRequestDTO.getUserEmail().trim() : "";
        String userAddress = (userRequestDTO.getUserAddress() != null) ? userRequestDTO.getUserAddress().trim() : "";
        String userGender = (userRequestDTO.getUserGender() != null) ? userRequestDTO.getUserGender().trim() : "";

        User user = new User(
                userRequestDTO.getUserId(),
                userRequestDTO.getUserPassword(),
                userRequestDTO.getUserName(),
                userRequestDTO.getUserPhone(),
                userEmail,
                userAddress,
                userGender
        );

        userRepository.save(user);
    }

    public Optional<User> findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    // 전화번호로 회원 존재 여부만 확인하는 메서드
    public boolean checkUserExistsByPhone(String userPhone) {
        Optional<User> existingUser = userRepository.findByUserPhone(userPhone);
        return existingUser.isPresent();
    }

    // 전화번호로 회원의 전체 정보를 찾아 반환하는 새로운 메서드
    public Optional<User> findUserByPhone(String userPhone) {
        return userRepository.findByUserPhone(userPhone);
    }
}