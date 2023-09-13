package com.coop.devopsservice.designPattern.lrx_observerPattern;

import com.coop.devopsservice.mapper.IterationMapper;

import java.util.ArrayList;

public abstract class IterationState {
    private int iterationId;
    IterationMapper iterationMapper;

    public IterationState(int iterationId, IterationMapper iterationMapper) {
        this.iterationId = iterationId;
        this.iterationMapper = iterationMapper;
        this.questions.add(new QuestionPermission("1"));
        this.questions.add(new QuestionPermission("2"));
        this.questions.add(new QuestionPermission("3"));
    }

    protected ArrayList<Observer> questions = new ArrayList<Observer>();
    public void addToIteration(Observer observer){
        questions.add(observer);
    }
    public int openIterationState(){
        notifyObserver(this.iterationId,"已开启",iterationMapper);
        return iterationMapper.openIteration(iterationId);
    }
    public int closeIterationState(){

        notifyObserver(this.iterationId,"未开启",iterationMapper);
        return iterationMapper.closeIteration(iterationId);
    }
    public abstract void notifyObserver(int iterationId,String iterationState,IterationMapper iterationMapper);

}
