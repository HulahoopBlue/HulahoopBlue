package com.ohgiraffers.travelkidari.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // HTTP 기본 인증 비활성화 (API 사용 시 기본 인증을 사용하지 않음)
                .httpBasic(AbstractHttpConfigurer::disable)
                // CSRF 공격 방어 기능 비활성화 (Postman 테스트 및 API 사용 시 필요)
                .csrf(AbstractHttpConfigurer::disable)
                // 특정 URL에 대한 요청을 허용
                .authorizeHttpRequests(authorize -> authorize
                        // 정적 HTML 파일 및 리소스에 대한 접근을 허용합니다.
                        .requestMatchers("/", "/*.html", "/css/**", "/js/**", "/images/**", "/logo.png").permitAll()
                        // 로그인 및 회원가입 관련 API는 모두에게 허용
                        .requestMatchers("/api/v1/users/login", "/api/v1/users/signup").permitAll()
                        // 예약 정보 조회 API는 인증 없이도 접근 허용 (요청에 따라 원복)
                        .requestMatchers("/reservations/list").permitAll()
                        // 그 외 모든 요청은 인증이 필요합니다.
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}