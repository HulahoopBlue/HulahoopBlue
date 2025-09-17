package com.hulahoopblue.blue.model.dto;

public class LoginDTO {

    private String id; // 로그인 아이디
    private String pw; // 로그인 비밀번호

    public LoginDTO() {}

    public LoginDTO(String pw, String id) {
        this.pw = pw;
        this.id = id;
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

    @Override
    public String toString() {
        return "LoginDTO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}

