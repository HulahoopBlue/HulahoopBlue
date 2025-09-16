package com.hulahoopblue.blue.kakaoapitest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KakaoAPIConfig {

    @Value("${kakao.map.js-key}")
    private String kakaoJsKey;

    public String getKakaoJsKey() {
        return kakaoJsKey;
    }
}
