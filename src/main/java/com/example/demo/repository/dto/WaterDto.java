package com.example.demo.repository.dto;

public class WaterDto {

    private String id;
    private String pointId;
    private String pointName;
    private String time;
    private String value;


    public WaterDto(String id, String pointId, String pointName, String time, String value) {
        this.id = id;
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
