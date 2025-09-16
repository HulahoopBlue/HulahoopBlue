package com.hulahoopblue.blue.kakaoapitest.controller;

import com.hulahoopblue.blue.kakaoapitest.config.KakaoAPIConfig;
import com.hulahoopblue.blue.kakaoapitest.model.dto.KaKaoMapDTO;
import com.hulahoopblue.blue.kakaoapitest.model.dto.UseHistoryDTO;
import com.hulahoopblue.blue.kakaoapitest.model.service.KakaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/kakao")
public class KakaoMapController {

    private final KakaoService kakaoService;
    private final KakaoAPIConfig kakaoAPIConfig;

    public KakaoMapController(KakaoService kakaoService, KakaoAPIConfig kakaoAPIConfig) {
        this.kakaoService = kakaoService;
        this.kakaoAPIConfig = kakaoAPIConfig;
    }

    @GetMapping("/chatDesign")
    public String kakao(Model model) {

        model.addAttribute("kakaoAPIkey",kakaoAPIConfig.getKakaoJsKey());

        return "kakao/chatDesign";
    }

    @ResponseBody
    @GetMapping("/markers")
    public List<KaKaoMapDTO> markers(){

        return kakaoService.getAllMarkers();
    }

    @PostMapping("/reservations")
    @ResponseBody
    public Map<String, Object> insertUseHistory(@RequestBody UseHistoryDTO dto) {  // ← @RequestBody 중요

        int inserted = kakaoService.reserveBike(dto);

        return Map.of("inserted", inserted);
    }
 }