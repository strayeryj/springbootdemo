package com.example.demo.repository.dto.powerStation;

public class StationInfoDto {
    private String method;
    private String stationCode;
    private String stationName;

    public StationInfoDto() {
    }

//    public StationInfoDto(String stationCode, String stationName) {
//        this.stationCode = stationCode;
//        this.stationName = stationName;
//    }

    public StationInfoDto(String method, String stationCode, String stationName) {
        this.method = method;
        this.stationCode = stationCode;
        this.stationName = stationName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "StationInfoDto{" +
                "method='" + method + '\'' +
                ", stationCode='" + stationCode + '\'' +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
