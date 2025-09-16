package com.hulahoopblue.blue.kakaoapitest.model.dto;

public class KaKaoMapDTO {

    private String bikeNo;       // T_Bike.product_num
    private String merchantNum;  // T_Bike.merchant_num
    private Double lat;
    private Double lng;
    private Integer priority;

    public KaKaoMapDTO() {}

    public KaKaoMapDTO(String bikeNo, String merchantNum, Double lat, Double lng, Integer priority) {
        this.bikeNo = bikeNo;
        this.merchantNum = merchantNum;
        this.lat = lat;
        this.lng = lng;
        this.priority = priority;
    }

    public String getBikeNo() { return bikeNo; }
    public void setBikeNo(String bikeNo) { this.bikeNo = bikeNo; }

    public String getMerchantNum() { return merchantNum; }
    public void setMerchantNum(String merchantNum) { this.merchantNum = merchantNum; }

    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    @Override
    public String toString() {
        return "KaKaoMapDTO{" +
                "bikeNo='" + bikeNo + '\'' +
                ", merchantNum='" + merchantNum + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", priority=" + priority +
                '}';
    }
}
