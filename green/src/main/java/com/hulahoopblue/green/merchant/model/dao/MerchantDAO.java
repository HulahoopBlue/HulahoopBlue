package com.hulahoopblue.green.merchant.model.dao;

import com.hulahoopblue.green.merchant.model.dto.MerchantDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MerchantDAO {
    List<MerchantDTO> findAllMerchants();
    List<MerchantDTO> findMerchantsByCriteria(@Param("params") Map<String, String> params);
}