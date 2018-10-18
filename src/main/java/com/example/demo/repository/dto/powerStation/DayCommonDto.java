package com.example.demo.repository.dto.powerStation;

public class DayCommonDto {
    private String method;
    private String code;
    private String name;
    private String time;
    private String type;
    private String vj;
    private String vf;
    private String vp;
    private String vg;
    private String value;
    private String mValue;
    private String yValue;

    public DayCommonDto(String method, String code, String name, String time, String type, String vj, String vf, String vp, String vg, String value, String mValue, String yValue) {
        this.method = method;
        this.code = code;
        this.name = name;
        this.time = time;
        this.type = type;
        this.vj = vj;
        this.vf = vf;
        this.vp = vp;
        this.vg = vg;
        this.value = value;
        this.mValue = mValue;
        this.yValue = yValue;
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

    public String getVj() {
        return vj;
    }

    public void setVj(String vj) {
        this.vj = vj;
    }

    public String getVf() {
        return vf;
    }

    public void setVf(String vf) {
        this.vf = vf;
    }

    public String getVp() {
        return vp;
    }

    public void setVp(String vp) {
        this.vp = vp;
    }

    public String getVg() {
        return vg;
    }

    public void setVg(String vg) {
        this.vg = vg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }

    public String getyValue() {
        return yValue;
    }

    public void setyValue(String yValue) {
        this.yValue = yValue;
    }
}
