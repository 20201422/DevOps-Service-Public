package com.coop.devopsservice.designPattern.lrx_observerPattern;

import com.coop.devopsservice.mapper.IterationMapper;

public class ConcreteIterationState extends IterationState{
    public ConcreteIterationState(int iterationId,IterationMapper iterationMapper) {
        super(iterationId, iterationMapper);
    }

    @Override
    public void notifyObserver(int iterationId,String iterationState,IterationMapper iterationMapper) {
        for(Object obj : questions){
            ((Observer)obj).changePermission(((QuestionPermission)obj).getQuestionId(),iterationState,iterationMapper);

        }
    }

}
