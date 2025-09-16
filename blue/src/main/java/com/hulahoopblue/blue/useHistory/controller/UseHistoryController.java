package com.hulahoopblue.blue.useHistory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kakao")
public class UseHistoryController {

    @GetMapping("/useHistory")
    public String useHistory() {
        return "kakao/useHistory";
    }
}
