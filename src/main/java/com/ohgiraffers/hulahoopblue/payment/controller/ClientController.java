package com.ohgiraffers.hulahoopblue.payment.controller;

import com.ohgiraffers.hulahoopblue.payment.dao.ClientMapper;
import com.ohgiraffers.hulahoopblue.payment.dto.ClientDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REST API 컨트롤러
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientMapper clientMapper;

    // 생성자 주입
    public ClientController(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    // 특정 고객사 ID로 노쇼 금액 조회 API
    @GetMapping("/{id}/fee")
    public int getClientFee(@PathVariable("id") int id) {
        ClientDTO client = clientMapper.findClientById(id);
        if (client == null) {
            throw new RuntimeException("❌ 해당 ID의 고객사가 존재하지 않습니다: " + id);
        }
        return client.getNoShowFee();
    }
}

