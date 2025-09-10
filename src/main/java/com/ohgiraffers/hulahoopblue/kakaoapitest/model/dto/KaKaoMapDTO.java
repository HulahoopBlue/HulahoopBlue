package com.ohgiraffers.hulahoopblue.kakaoapitest.model.dto;

public class KaKaoMapDTO {

    private String bikeNo;
    private String franchise;
    private Double lat;
    private Double lng;
    private int priority;

    public KaKaoMapDTO(){}

    public KaKaoMapDTO(String bikeNo, String franchise, Double lat, Double lng, int priority) {
        this.bikeNo = bikeNo;
        this.franchise = franchise;
        this.lat = lat;
        this.lng = lng;
        this.priority = priority;
    }

    public String getBikeNo() {
        return bikeNo;
    }

    public void setBikeNo(String bikeNo) {
        this.bikeNo = bikeNo;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "KaKaoMapDTO{" +
                "bikeNo='" + bikeNo + '\'' +
                ", franchise='" + franchise + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", priority=" + priority +
                '}';
    }
}
