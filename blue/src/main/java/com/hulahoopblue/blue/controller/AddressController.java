package com.hulahoopblue.blue.controller;

import com.hulahoopblue.blue.model.dto.AddressDTO;
import com.hulahoopblue.blue.model.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/search-address")
    public List<AddressDTO> searchAddress(@RequestParam String keyword) {
        try {
            return addressService.searchAddress(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // 예외 발생 시 빈 리스트 반환
        }
    }
}
