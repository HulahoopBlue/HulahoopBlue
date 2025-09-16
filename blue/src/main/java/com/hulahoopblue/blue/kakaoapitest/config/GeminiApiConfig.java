package com.hulahoopblue.blue.kakaoapitest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GeminiApiConfig {


    @Bean("apiRestTemplate")
    public RestTemplate apiRestTemplate() {
        return new RestTemplate();
    }
}
