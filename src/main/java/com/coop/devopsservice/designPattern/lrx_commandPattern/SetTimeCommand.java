package com.coop.devopsservice.designPattern.lrx_commandPattern;

import com.coop.devopsservice.mapper.IterationMapper;

public class SetTimeCommand extends Command{
    private int iterationId;
    private String startTime;
    private String endTime;
    IterationMapper iterationMapper;
    SetTime setTime;

    public SetTimeCommand(int iterationId, String startTime, String endTime, IterationMapper iterationMapper) {
        this.iterationId = iterationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.iterationMapper = iterationMapper;
        setTime = new SetTime();
    }
    public SetTimeCommand() {}
    @Override
    public int execute() {
        return setTime.doAction(iterationId, startTime, endTime, iterationMapper);
    }

    public int getIterationId() {
        return iterationId;
    }

    public void setIterationId(int iterationId) {
        this.iterationId = iterationId;
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
}
