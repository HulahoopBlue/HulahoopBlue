package com.hulahoopblue.green.member.model.dto;

public class MemberDTO {
    private String memberNum;
    private String id;
    private String pw;
    private String email;
    private String nm;
    private String phoneNum;
    private String address;
    private String msgNotiStatus;
    private int userTyp;
    private String merchantNum;

    public String getMemberNum() {
        return memberNum;
    }
    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNm() {
        return nm;
    }
    public void setNm(String nm) {
        this.nm = nm;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMsgNotiStatus() {
        return msgNotiStatus;
    }
    public void setMsgNotiStatus(String msgNotiStatus) {
        this.msgNotiStatus = msgNotiStatus;
    }
    public int getUserTyp() {
        return userTyp;
    }
    public void setUserTyp(int userTyp) {
        this.userTyp = userTyp;
    }
    public String getMerchantNum() {
        return merchantNum;
    }
    public void setMerchantNum(String merchantNum) {
        this.merchantNum = merchantNum;
    }

}
