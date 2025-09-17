package com.hulahoopblue.blue.model.dto;

public class KaKaoMapDTO {

    private String categoryCd;
    private String productNum;
    private String merchantNum;
    private String merchantNm;
    private Double lat;
    private Double lng;
    private Integer priority;
    private Integer cnt;

    public KaKaoMapDTO() {}

    public KaKaoMapDTO(String categoryCd, String productNum, String merchantNum, String merchantNm, Double lat, Double lng, Integer priority, Integer cnt) {
        this.categoryCd = categoryCd;
        this.productNum = productNum;
        this.merchantNum = merchantNum;
        this.merchantNm = merchantNm;
        this.lat = lat;
        this.lng = lng;
        this.priority = priority;
        this.cnt = cnt;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public void setMerchantNum(String merchantNum) {
        this.merchantNum = merchantNum;
    }

    public void setMerchantNm(String merchantNm) {
        this.merchantNm = merchantNm;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public String getCategoryCd() {
        return categoryCd;
    }

    public String getProductNum() {
        return productNum;
    }

    public String getMerchantNum() {
        return merchantNum;
    }

    public String getMerchantNm() {
        return merchantNm;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getCnt() {
        return cnt;
    }

    @Override
    public String toString() {
        return "KaKaoMapDTO{" +
                "categoryCd='" + categoryCd + '\'' +
                ", productNum='" + productNum + '\'' +
                ", merchantNum='" + merchantNum + '\'' +
                ", merchantNm='" + merchantNm + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", priority=" + priority +
                ", cnt=" + cnt +
                '}';
    }
}
