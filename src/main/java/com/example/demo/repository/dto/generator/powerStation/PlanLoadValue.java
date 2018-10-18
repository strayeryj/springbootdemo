package com.example.demo.repository.dto.generator.powerStation;

public class PlanLoadValue {
    private String method;

    private String nodeId;

    private String dataName;

    private String dataTime;

    private String planLoad;

    private String planValue;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getPlanLoad() {
        return planLoad;
    }

    public void setPlanLoad(String planLoad) {
        this.planLoad = planLoad;
    }

    public String getPlanValue() {
        return planValue;
    }

    public void setPlanValue(String planValue) {
        this.planValue = planValue;
    }
}