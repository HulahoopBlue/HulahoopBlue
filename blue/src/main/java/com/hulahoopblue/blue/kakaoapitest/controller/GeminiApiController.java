package com.hulahoopblue.blue.kakaoapitest.controller;
import com.hulahoopblue.blue.kakaoapitest.model.service.GeminiApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GeminiApiController {

    private final GeminiApiService geminiApiService;

    @Autowired
    public GeminiApiController(GeminiApiService geminiApiService) {
        this.geminiApiService = geminiApiService;
    }

    @PostMapping("/generate")
    public String generateContent(@RequestBody String prompt) {
        return geminiApiService.callGeminiApi(prompt);
    }
}