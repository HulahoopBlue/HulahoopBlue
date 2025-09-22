package com.ohgiraffers.travelkidari.api.user.dto;

public class UserRequestDTO {

    private String userId;
    private String userPassword;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userAddress;
    private String userGender;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String userId, String userPassword, String userName, String userPhone, String userEmail, String userAddress, String userGender) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userGender = userGender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}