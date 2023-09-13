package com.coop.devopsservice.designPattern.lrx_observerPattern;

import com.coop.devopsservice.mapper.IterationMapper;

public interface Observer {
    void changePermission(String questionId, String iterationState, IterationMapper iterationMapper);
}
