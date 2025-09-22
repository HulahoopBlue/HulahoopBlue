package com.ohgiraffers.travelkidari.config;

import com.ohgiraffers.travelkidari.api.apikey.domain.ApiKey;
import com.ohgiraffers.travelkidari.api.apikey.service.ApiKeyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String API_KEY_HEADER = "X-API-KEY";
    private final ApiKeyService apiKeyService;

    public ApiKeyInterceptor(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = request.getRequestURI();
        if (path.startsWith("/api/v1/users/signup") || path.startsWith("/api/v1/users/login")) {
            return true;
        }

        String apiKey = request.getHeader(API_KEY_HEADER);

        if (apiKey == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("API Key가 누락되었습니다.");
            return false;
        }

        ApiKey validApiKey = apiKeyService.findByApiKey(apiKey);
        if (validApiKey == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("유효하지 않은 API Key입니다.");
            return false;
        }

        return true;
    }
}