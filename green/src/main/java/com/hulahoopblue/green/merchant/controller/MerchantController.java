package com.hulahoopblue.green.merchant.controller;

import com.hulahoopblue.green.merchant.model.dto.MerchantDTO;
import com.hulahoopblue.green.merchant.model.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/list")
    public String listPage() {
        return "merchant/merchantSelect"; // 뷰 이름을 소문자로 수정
    }


    @GetMapping("/api/search")
    @ResponseBody
    public List<MerchantDTO> searchMerchants(@RequestParam Map<String, String> params) {
        return merchantService.searchMerchants(params);
    }
    @GetMapping("/merchantSelect")
    public String merchantSelectPage() {
        return "merchant/merchantSelect";  // templates/merchant/merchantSelect.html
    }

}