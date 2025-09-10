// com/ohgiraffers/controller/PaymentController.java
package com.ohgiraffers.hulahoopblue.payment.controller;

import com.ohgiraffers.hulahoopblue.payment.dao.ClientMapper;
import com.ohgiraffers.hulahoopblue.payment.dto.ClientDTO;
import com.ohgiraffers.hulahoopblue.payment.dao.UsageHistoryMapper;
import com.ohgiraffers.hulahoopblue.payment.dto.UsageHistoryDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final ClientMapper clientMapper;
    private final UsageHistoryMapper usageHistoryMapper;

    public PaymentController(ClientMapper clientMapper, UsageHistoryMapper usageHistoryMapper) {
        this.clientMapper = clientMapper;
        this.usageHistoryMapper = usageHistoryMapper;
    }

    // 네이버페이 returnUrl (GET)
    // 예: http://localhost:8080/payment/return?clientId=1&merchantPayKey=...
    @GetMapping("/return")
    public String handleNaverPayReturn(@RequestParam("clientId") int clientId,
                                       @RequestParam(value = "merchantPayKey", required = false) String merchantPayKey,
                                       @RequestParam(value = "resultCode", required = false) String resultCode) {
        // ⚠️ 실제 운영에서는 resultCode 확인 + 네이버페이 승인/검증 API 호출 필요
        // 테스트에서는 DB 금액을 재조회해서 기록
        ClientDTO client = clientMapper.findClientById(clientId);
        if (client == null) return "고객사 없음";

        UsageHistoryDTO usage = new UsageHistoryDTO();
        usage.setClientId(clientId);
        usage.setAmount(client.getNoShowFee());
        usageHistoryMapper.insertUsage(usage);

        return "결제 성공(테스트) - 내역 저장 완료";
    }
}
