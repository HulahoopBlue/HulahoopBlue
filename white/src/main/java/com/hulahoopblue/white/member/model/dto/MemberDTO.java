package com.hulahoopblue.white.member.model.dto;

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

    public MemberDTO() {}

    public MemberDTO(String memberNum, String id, String pw, String email, String nm, String phoneNum, String address, String msgNotiStatus, int userTyp) {
        this.memberNum = memberNum;
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.nm = nm;
        this.phoneNum = phoneNum;
        this.address = address;
        this.msgNotiStatus = msgNotiStatus;
        this.userTyp = userTyp;
    }

    public int getUserTyp() {
        return userTyp;
    }

    public void setUserTyp(int userTyp) {
        this.userTyp = userTyp;
    }

    public String getMsgNotiStatus() {
        return msgNotiStatus;
    }

    public void setMsgNotiStatus(String msgNotiStatus) {
        this.msgNotiStatus = msgNotiStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNum='" + memberNum + '\'' +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                ", nm='" + nm + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                ", msgNotiStatus='" + msgNotiStatus + '\'' +
                ", userTyp=" + userTyp +
                '}';
    }
}
