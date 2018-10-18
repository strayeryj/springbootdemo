package com.example.demo.repository.dto;

public class DeviceGroupDto {
    private String id;
    private String route;

    public DeviceGroupDto() {
    }

    @Override
    public String toString() {
        return "DeviceGroupDto{" +
                "id='" + id + '\'' +
                ", route='" + route + '\'' +
                '}';
    }

    public DeviceGroupDto(String id, String route) {
        this.id = id;
        this.route = route;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
