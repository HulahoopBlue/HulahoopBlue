package com.hulahoopblue.blue.controller;

import com.hulahoopblue.blue.model.dao.PaymentDAO;
import com.hulahoopblue.blue.model.dto.MerchantDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentDAO merchantMapper;

    public PaymentController(PaymentDAO merchantMapper) {
        this.merchantMapper = merchantMapper;
    }

//    @GetMapping("/{id}/fee")
//    public Double getClientFee(@PathVariable String id) {
//        MerchantDTO merchantDTO = merchantMapper.findClientById(id);
//
//        if (merchantDTO == null) {
//            throw new RuntimeException("❌ 해당 ID의 고객사가 존재하지 않습니다: " + id);
//        }
//        return merchantDTO.getBrokerage();
//    }

    @PostMapping("/fee")
    public Double getClientFee(@RequestBody Map<String, String> payload) {
        String id = payload.get("merchantNum");

        System.out.println("merchantNum : ");

        MerchantDTO merchantDTO = merchantMapper.findClientById(id);

        if (merchantDTO == null) {
            throw new RuntimeException("❌ 해당 ID의 고객사가 존재하지 않습니다: " + id);
        }
        return merchantDTO.getBrokerage();
    }


    @GetMapping("/return")
    public String handleNaverPayReturn(@RequestParam("clientId") String clientId,
                                       @RequestParam(value = "merchantPayKey", required = false) String merchantPayKey,
                                       @RequestParam(value = "resultCode", required = false) String resultCode) {

        String alertMessage = "결제 완료(테스트)";
        String redirectUrl = "/kakao/blueApplication";

        return "<!DOCTYPE html><html><body><script>"
                + "alert('" + alertMessage + "');"
                + "window.location.href = '" + redirectUrl + "';"
                + "</script></body></html>";
    }
}
