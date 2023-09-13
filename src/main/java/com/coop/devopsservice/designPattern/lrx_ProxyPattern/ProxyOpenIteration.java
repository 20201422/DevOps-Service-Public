package com.coop.devopsservice.designPattern.lrx_ProxyPattern;

import com.coop.devopsservice.designPattern.lrx_observerPattern.IterationState;
import com.coop.devopsservice.mapper.IterationMapper;

public class ProxyOpenIteration implements OpenIteration{
    IterationState iterationState;
    IterationMapper iterationMapper;
    private String projectId;

    public ProxyOpenIteration(IterationState iterationState, IterationMapper iterationMapper, String projectId) {
        this.iterationState = iterationState;
        this.iterationMapper = iterationMapper;
        this.projectId = projectId;
    }

    @Override
    public int open() {
        int count = iterationMapper.getOpenedCount(projectId);//已开启迭代数量
        if(count<1) {//当开启迭代的数量小于1时才能开启迭代
            return iterationState.openIterationState();
        }
        return iterationState.closeIterationState();
    }
}
