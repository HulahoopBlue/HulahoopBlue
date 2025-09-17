package com.hulahoopblue.blue.model.dto;

import java.time.LocalDateTime;

public class GeminiApiDTO {

    private String dataType;
    private LocalDateTime accessDateTime;
    private int accessResult;
    private String fileNm;
    private String etc;

    public GeminiApiDTO() {
    }

    public GeminiApiDTO(String dataType, LocalDateTime accessDateTime, int accessResult, String fileNm, String etc) {
        this.dataType = dataType;
        this.accessDateTime = accessDateTime;
        this.accessResult = accessResult;
        this.fileNm = fileNm;
        this.etc = etc;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setAccessDateTime(LocalDateTime accessDateTime) {
        this.accessDateTime = accessDateTime;
    }

    public void setAccessResult(int accessResult) {
        this.accessResult = accessResult;
    }

    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getDataType() {
        return dataType;
    }

    public LocalDateTime getAccessDateTime() {
        return accessDateTime;
    }

    public int getAccessResult() {
        return accessResult;
    }

    public String getFileNm() {
        return fileNm;
    }

    public String getEtc() {
        return etc;
    }
}