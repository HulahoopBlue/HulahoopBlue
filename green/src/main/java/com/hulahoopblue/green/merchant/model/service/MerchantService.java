package com.hulahoopblue.green.merchant.model.service;

import com.hulahoopblue.green.merchant.model.dao.MerchantDAO;
import com.hulahoopblue.green.merchant.model.dto.MerchantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MerchantService {

    @Autowired
    private MerchantDAO merchantDAO;

    public List<MerchantDTO> searchMerchants(Map<String, String> params) {
        if (params.isEmpty() || params.values().stream().allMatch(String::isEmpty)) {
            return merchantDAO.findAllMerchants();
        } else {
            return merchantDAO.findMerchantsByCriteria(params);
        }
    }
}