package com.ohgiraffers.travelkidari.api.user.dto;

public class LoginRequestDTO {

    private String userId;
    private String password; // 필드명이 password일 가능성이 높음

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // getPassword() 메서드 추가
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}