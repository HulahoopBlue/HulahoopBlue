package com.ohgiraffers.hulahoopblue.kakaoapitest.controller;

import com.ohgiraffers.hulahoopblue.config.KakaoAPIConfig;
import com.ohgiraffers.hulahoopblue.kakaoapitest.model.dto.KaKaoMapDTO;
import com.ohgiraffers.hulahoopblue.kakaoapitest.model.service.KakaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/kakao")
public class KakaoController {

    private final KakaoService kakaoService;
    private final KakaoAPIConfig kakaoAPIConfig;

    public KakaoController(KakaoService kakaoService, KakaoAPIConfig kakaoAPIConfig) {
        this.kakaoService = kakaoService;
        this.kakaoAPIConfig = kakaoAPIConfig;
    }

    @GetMapping("/kakaoMap")
    public String kakaoAPI(Model model) {

        model.addAttribute("kakaoAPIkey",kakaoAPIConfig.getKakaoJsKey());

        return "kakao/kakaoMap";
    }

    @ResponseBody
    @GetMapping("/markers")
    public List<KaKaoMapDTO> markers(){
         return kakaoService.getAllMarkers();
    }
 }