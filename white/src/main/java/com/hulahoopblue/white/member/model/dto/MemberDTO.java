package com.hulahoopblue.white.member.model.dto;

public class MemberDTO {

    private String memberNum;      // 회원번호
    private String id;             // 아이디
    private String pw;             // 비밀번호 (SHA256 암호화)
    private String email;          // 이메일
    private String nm;             // 회원명
    private String phoneNum;       // 전화번호
    private String address;        // 주소
    private String msgNotiStatus;  // 메세지 알림 상태 (Y/N)
    private int userTyp;           // 사용자 구분 (1:사용자, 2:관리자, 3:가맹점 사용자)

    // 기본 생성자
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