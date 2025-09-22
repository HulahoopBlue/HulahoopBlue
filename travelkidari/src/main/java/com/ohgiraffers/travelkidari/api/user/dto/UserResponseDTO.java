package com.ohgiraffers.travelkidari.api.user.dto;

public class UserResponseDTO {

    private String message;

    public UserResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}