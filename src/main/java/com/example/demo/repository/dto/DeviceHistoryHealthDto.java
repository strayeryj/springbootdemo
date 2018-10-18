package com.example.demo.repository.dto;

public class DeviceHistoryHealthDto {

    private String route;
    private String time;
    private String value;

    public DeviceHistoryHealthDto(String route, String time, String value) {
        this.route = route;
        this.time = time;
        this.value = value;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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
        return "DeviceHistoryHealthDto{" +
                "route='" + route + '\'' +
                ", time='" + time + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
