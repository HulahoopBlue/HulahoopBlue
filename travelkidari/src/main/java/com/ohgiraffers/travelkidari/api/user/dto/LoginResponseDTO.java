package com.ohgiraffers.travelkidari.api.user.dto;

public class LoginResponseDTO {
    private String token;
    private long expireTime;

    public LoginResponseDTO(String token, long expireTime) {
        this.token = token;
        this.expireTime = expireTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}