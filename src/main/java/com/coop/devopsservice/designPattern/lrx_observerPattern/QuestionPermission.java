package com.coop.devopsservice.designPattern.lrx_observerPattern;

import com.coop.devopsservice.mapper.IterationMapper;

public class QuestionPermission implements Observer{
    private String questionId ;

    public QuestionPermission(String questionId) {
        this.questionId = questionId;
    }

    @Override
    public void changePermission(String questionId, String iterationState, IterationMapper iterationMapper) {
        if(iterationState.equals("已开启")){
            System.out.println(questionId+"权限变更：可操作");//将问题的状态变为可操作
        }else {
            System.out.println(questionId+"权限变更：不可操作");//将问题的状态变为不可操作
        }
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
