package com.example.demo.repository.dto;

public class WaterCommon2Dto {

    private String id;
    private String type;
    private String pointId;
    private String pointName;
    private String x;
    private String y1;
    private String y2;


    public WaterCommon2Dto(String id, String type, String pointId, String pointName, String x, String y1, String y2) {
        this.id = id;
        this.type = type;
        this.pointId = pointId;
        this.pointName = pointName;
        this.x = x;
        this.y1 = y1;
        this.y2 = y2;
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

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY1() {
        return y1;
    }

    public void setY1(String y1) {
        this.y1 = y1;
    }

    public String getY2() {
        return y2;
    }

    public void setY2(String y2) {
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "WaterCommon2Dto{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", pointId='" + pointId + '\'' +
                ", pointName='" + pointName + '\'' +
                ", x='" + x + '\'' +
                ", y1='" + y1 + '\'' +
                ", y2='" + y2 + '\'' +
                '}';
    }
}
