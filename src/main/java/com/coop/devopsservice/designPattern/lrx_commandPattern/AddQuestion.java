package com.coop.devopsservice.designPattern.lrx_commandPattern;

import com.coop.devopsservice.mapper.IterationMapper;

public class AddQuestion {
    public int doAction(String questionId, int iterationId,IterationMapper iterationMapper){
        System.out.println("执行添加问题命令");
        return iterationMapper.addQuestionToIterationById(questionId, iterationId);
    }
}
