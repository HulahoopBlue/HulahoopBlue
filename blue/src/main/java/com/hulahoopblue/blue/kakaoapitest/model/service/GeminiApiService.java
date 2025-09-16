package com.hulahoopblue.blue.kakaoapitest.model.service;

import com.hulahoopblue.blue.kakaoapitest.model.dao.GeminiApiDAO;
import com.hulahoopblue.blue.kakaoapitest.model.dto.GeminiApiDTO;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class GeminiApiService {

    @Value("${Gemini.api.key}")
    private String apiKey;

    @Value("${Gemini.api.url}")
    private String url;

    private final RestTemplate restTemplate = new RestTemplate();
    private final GeminiApiDAO geminiApiDAO;

    public GeminiApiService(GeminiApiDAO geminiApiDAO) {
        this.geminiApiDAO = geminiApiDAO;
    }

    public String callGeminiApi(String prompt) {
        String requestUrl = url + "?key=" + apiKey;

        // JSON 문자열 내부에 들어갈 따옴표 등 특수문자를 안전하게 이스케이프 처리
        String escapedPrompt = StringEscapeUtils.escapeJson(prompt);

        // Gemini API가 요구하는 JSON 요청 본문을 구성
        String requestBody = String.format("{\"contents\": [{\"parts\": [{\"text\": \"%s\"}]}]}", escapedPrompt);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        int result = 0;
        String responseBody = null;

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(requestUrl, entity, String.class);
            responseBody = response.getBody();
            result = 1;
        } catch (HttpClientErrorException e) {
            // ... (생략) ...
            result = 0;
            throw new RuntimeException("Gemini API 호출 중 HTTP 오류 발생: " + e.getMessage(), e);
        } catch (Exception e) {
            // ... (생략) ...
            result = 0;
            throw new RuntimeException("Gemini API 호출 중 알 수 없는 오류 발생: " + e.getMessage(), e);
        } finally {
            GeminiApiDTO historyDto = new GeminiApiDTO("2", LocalDateTime.now(), result, null, null);
            geminiApiDAO.geminiApiRegist(historyDto);
        }

        return responseBody;
    }
}