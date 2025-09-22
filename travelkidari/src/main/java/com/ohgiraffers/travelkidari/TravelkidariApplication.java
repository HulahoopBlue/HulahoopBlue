package com.ohgiraffers.travelkidari;

import com.ohgiraffers.travelkidari.api.user.dto.UserRequestDTO;
import com.ohgiraffers.travelkidari.api.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelkidariApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelkidariApplication.class, args);
    }

    /*
     * 아래 코드는 임시 테스트용입니다.
     * 사용이 완료되면 삭제하거나 주석 처리해야 합니다.
     * 애플리케이션 시작 시 자동으로 실행됩니다.
     */
//    @Bean
//    public CommandLineRunner createTestUser(UserService userService) {
//        return args -> {
//            try {
//                UserRequestDTO userRequestDTO = new UserRequestDTO(
//                        "testUser1",
//                        "testPassword1",
//                        "테스트유저",
//                        "01012345678",
//                        "test@example.com",
//                        "서울시",
//                        "남"
//                );
//                userService.registerUser(userRequestDTO);
//                System.out.println("✅ 새로운 사용자가 성공적으로 등록되었습니다. (전화번호: 01012345678)");
//            } catch (Exception e) {
//                System.err.println("❌ 사용자 등록 중 오류가 발생했습니다: " + e.getMessage());
//            }
//        };
//    }
}