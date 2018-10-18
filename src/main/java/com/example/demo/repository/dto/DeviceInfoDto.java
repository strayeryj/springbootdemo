package com.example.demo.repository.dto;

public class DeviceInfoDto {
    private String id;
    private String pId;
    private String hpi;
    private String time;
    private String name;
    private String state;
    private String similarSet;


    public DeviceInfoDto(String id, String pId, String hpi, String time, String name, String state, String similarSet) {
        this.id = id;
        this.pId = pId;
        this.hpi = hpi;
        this.time = time;
        this.name = name;
        this.state = state;
        this.similarSet = similarSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getHpi() {
        return hpi;
    }

    public void setHpi(String hpi) {
        this.hpi = hpi;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSimilarSet() {
        return similarSet;
    }

    public void setSimilarSet(String similarSet) {
        this.similarSet = similarSet;
    }


    @Override
    public String toString() {
        return "DeviceInfoDto{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", hpi='" + hpi + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", similarSet='" + similarSet + '\'' +
                '}';
    }
}
