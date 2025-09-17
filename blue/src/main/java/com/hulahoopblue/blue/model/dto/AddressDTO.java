package com.hulahoopblue.blue.model.dto;

public class AddressDTO {
    private String roadAddr;
    private String jibunAddr;

    // 기본 생성자
    public AddressDTO() {}

    // 생성자
    public AddressDTO(String roadAddr, String jibunAddr) {
        this.roadAddr = roadAddr;
        this.jibunAddr = jibunAddr;
    }

    // getter / setter
    public String getRoadAddr() {
        return roadAddr;
    }

    public void setRoadAddr(String roadAddr) {
        this.roadAddr = roadAddr;
    }

    public String getJibunAddr() {
        return jibunAddr;
    }

    public void setJibunAddr(String jibunAddr) {
        this.jibunAddr = jibunAddr;
    }
}
