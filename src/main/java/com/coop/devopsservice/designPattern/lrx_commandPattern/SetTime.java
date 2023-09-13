package com.coop.devopsservice.designPattern.lrx_commandPattern;

import com.coop.devopsservice.mapper.IterationMapper;

public class SetTime {
    public int doAction(int iterationId, String startTime, String endTime, IterationMapper iterationMapper){
        return iterationMapper.setTime(iterationId,startTime,endTime);
    }
}
