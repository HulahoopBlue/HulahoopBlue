package com.hulahoopblue.blue.controller;

import com.hulahoopblue.blue.config.KakaoAPIConfig;
import com.hulahoopblue.blue.model.dto.KaKaoMapDTO;
import com.hulahoopblue.blue.model.dto.UseHistoryDTO;
import com.hulahoopblue.blue.model.service.KakaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class KakaoMapController {

    private final KakaoService kakaoService;
    private final KakaoAPIConfig kakaoAPIConfig;

    public KakaoMapController(KakaoService kakaoService, KakaoAPIConfig kakaoAPIConfig) {
        this.kakaoService = kakaoService;
        this.kakaoAPIConfig = kakaoAPIConfig;
    }

    @ResponseBody
    @GetMapping("/markers")
    public List<KaKaoMapDTO> markers(@RequestParam("productType") String productType){

        return kakaoService.getAllMarkers(productType);
    }

    @PostMapping("/reservations")
    @ResponseBody
    public Map<String, Object> insertUseHistory(@RequestBody UseHistoryDTO dto) {  // ← @RequestBody 중요

        int inserted = kakaoService.reserveBike(dto);

        return Map.of("inserted", inserted);
    }




 }