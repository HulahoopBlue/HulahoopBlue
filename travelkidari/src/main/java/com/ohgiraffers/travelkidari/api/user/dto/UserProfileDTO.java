package com.ohgiraffers.travelkidari.api.user.dto;

import com.ohgiraffers.travelkidari.api.user.domain.User;

public class UserProfileDTO {
    private String userId;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userAddress;
    private String userGender;
    private String userRole;

    public UserProfileDTO() {}

    public UserProfileDTO(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userPhone = user.getUserPhone();
        this.userEmail = user.getUserEmail();
        this.userAddress = user.getUserAddress();
        this.userGender = user.getUserGender();
        this.userRole = user.getUserRole();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserRole() {
        return userRole;
    }
}