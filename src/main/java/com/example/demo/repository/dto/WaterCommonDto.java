package com.example.demo.repository.dto;

public class WaterCommonDto {

    private String id;
    private String type;
    private String pointId;
    private String pointName;
    private String time;
    private String value;


    public WaterCommonDto(String id, String type,String pointId, String pointName, String time, String value) {
        this.id = id;
        this.type = type;
        this.pointId = pointId;
        this.pointName = pointName;
        this.time = time;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "WaterDto{" +
                "id='" + id + '\'' +
                ", pointId='" + pointId + '\'' +
                ", pointName='" + pointName + '\'' +
                ", time='" + time + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
