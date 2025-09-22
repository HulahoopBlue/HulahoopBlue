package com.ohgiraffers.travelkidari.api.apikey.service;

import com.ohgiraffers.travelkidari.api.apikey.domain.ApiKey;
import com.ohgiraffers.travelkidari.api.apikey.domain.ApiKeyRepository;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    public ApiKey findByApiKey(String apiKey) {
        return apiKeyRepository.findByApiKey(apiKey)
                .filter(ApiKey::isEnabled)
                .orElse(null);
    }
}