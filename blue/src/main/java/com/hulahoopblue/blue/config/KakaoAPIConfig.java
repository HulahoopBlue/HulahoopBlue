package com.hulahoopblue.blue.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KakaoAPIConfig {

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    public String getKakaoApiKey() {
        return kakaoApiKey;
    }
}
