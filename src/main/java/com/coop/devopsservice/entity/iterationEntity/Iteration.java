package com.coop.devopsservice.entity.iterationEntity;

import java.util.Date;

public class Iteration {
    private int iterationId;
    private String iterationName;
    private String iterationDescribe;
    private String iterationState;
    private String startTime;
    private String endTime;
    private String projectId;

    public Iteration(int iterationId, String iterationName, String iterationDescribe, String iterationState, String startTime, String endTime, String projectId) {
        this.iterationId = iterationId;
        this.iterationName = iterationName;
        this.iterationDescribe = iterationDescribe;
        this.iterationState = iterationState;
        this.startTime = startTime;
        this.endTime = endTime;
        this.projectId = projectId;
    }

    public Iteration() {
    }

    public int getIterationId() {
        return iterationId;
    }

    public void setIterationId(int iterationId) {
        this.iterationId = iterationId;
    }

    public String getIterationName() {
        return iterationName;
    }

    public void setIterationName(String iterationName) {
        this.iterationName = iterationName;
    }

    public String getIterationDescribe() {
        return iterationDescribe;
    }

    public void setIterationDescribe(String iterationDescribe) {
        this.iterationDescribe = iterationDescribe;
    }

    public String getIterationState() {
        return iterationState;
    }

    public void setIterationState(String iterationState) {
        this.iterationState = iterationState;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
