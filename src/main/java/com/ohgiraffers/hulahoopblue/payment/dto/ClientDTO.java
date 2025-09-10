package com.ohgiraffers.hulahoopblue.payment.dto;

public class ClientDTO {
    private int id;             // 고객사 고유 ID
    private String clientName;  // 고객사 이름
    private int noShowFee;      // 노쇼 금액

    // 기본 생성자
    public ClientDTO() {}

    // 전체 필드 생성자
    public ClientDTO(int id, String clientName, int noShowFee) {
        this.id = id;
        this.clientName = clientName;
        this.noShowFee = noShowFee;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getNoShowFee() {
        return noShowFee;
    }

    public void setNoShowFee(int noShowFee) {
        this.noShowFee = noShowFee;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", noShowFee=" + noShowFee +
                '}';
    }
}
