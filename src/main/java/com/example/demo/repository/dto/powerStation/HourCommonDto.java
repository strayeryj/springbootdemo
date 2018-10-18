package com.example.demo.repository.dto.powerStation;

public class HourCommonDto {
    private String method;
    private String code;
    private String name;
    private String time;
    private String type;
    private String value;

    public HourCommonDto(String method, String code, String name, String time, String type, String value) {
        this.method = method;
        this.code = code;
        this.name = name;
        this.time = time;
        this.type = type;
        this.value = value;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
