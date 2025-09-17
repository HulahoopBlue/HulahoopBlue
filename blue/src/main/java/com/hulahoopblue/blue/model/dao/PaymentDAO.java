package com.hulahoopblue.blue.model.dao;

import com.hulahoopblue.blue.model.dto.MerchantDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDAO {
    // 단일 고객사 조회
    MerchantDTO findClientById(String id);

}

