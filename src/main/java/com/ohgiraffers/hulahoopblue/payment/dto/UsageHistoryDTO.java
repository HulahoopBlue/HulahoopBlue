package com.ohgiraffers.hulahoopblue.payment.dto;

import java.time.LocalDateTime;

public class UsageHistoryDTO {
    private int id;             // 이용내역 고유 ID
    private int clientId;       // 고객사 ID (FK)
    private int amount;         // 결제 금액
    private LocalDateTime usedAt; // 결제 일시

    // 기본 생성자
    public UsageHistoryDTO() {}

    // 전체 필드 생성자
    public UsageHistoryDTO(int id, int clientId, int amount, LocalDateTime usedAt) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.usedAt = usedAt;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(LocalDateTime usedAt) {
        this.usedAt = usedAt;
    }

    @Override
    public String toString() {
        return "UsageHistoryDTO{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", amount=" + amount +
                ", usedAt=" + usedAt +
                '}';
    }
}
