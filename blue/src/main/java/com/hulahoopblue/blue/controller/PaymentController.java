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

    @PostMapping("/fee")
    public Double getClientFee(@RequestBody Map<String, String> payload) {
        String id = payload.get("merchantNum");

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

        String alertMessage;
        String redirectUrl = "/blueApplication";

        if ("Success".equals(resultCode)) {
            alertMessage = "결제가 성공적으로 완료되었습니다.";
        } else {
            alertMessage = "결제에 실패했거나 취소되었습니다. 다시 시도해 주세요.";
        }

        return "<!DOCTYPE html><html><body><script>"
                + "alert('" + alertMessage + "');"
                + "window.location.href = '" + redirectUrl + "';"
                + "</script></body></html>";
    }

}
