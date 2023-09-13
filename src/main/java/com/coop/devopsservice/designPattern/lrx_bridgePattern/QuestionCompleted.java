package com.coop.devopsservice.designPattern.lrx_bridgePattern;

import com.coop.devopsservice.entity.questionEntity.ShowQuestions;
import com.coop.devopsservice.mapper.QuestionMapper;

import java.util.List;

public class QuestionCompleted extends QuestionFilter{


    public QuestionCompleted(Priority priority, String projectId, QuestionMapper questionMapper) {
        super(priority, projectId, questionMapper);
    }

    @Override
    public List<ShowQuestions> showQuestions() {
        return questionMapper.findQuestionByStateAndPriority(projectId,"已实现",priority.getPriority());
        //System.out.println("问题筛选条件为----状态：已实现 优先级："+super.priority.getPriority());
    }
}
