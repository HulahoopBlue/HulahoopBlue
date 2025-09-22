package com.ohgiraffers.travelkidari.api.apikey.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_api_key")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_id")
    private int keyId;

    @Column(name = "api_key", nullable = false, unique = true)
    private String apiKey;

    @Column(name = "description")
    private String description;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    protected ApiKey() {}

    public ApiKey(String apiKey, String description, boolean isEnabled) {
        this.apiKey = apiKey;
        this.description = description;
        this.isEnabled = isEnabled;
        this.createdAt = LocalDateTime.now();
    }

    public int getKeyId() {
        return keyId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "ApiKey{" +
                "keyId=" + keyId +
                ", apiKey='" + apiKey + '\'' +
                ", description='" + description + '\'' +
                ", isEnabled=" + isEnabled +
                ", createdAt=" + createdAt +
                '}';
    }
}