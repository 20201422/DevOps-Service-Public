package com.coop.devopsservice.designPattern.lrx_bridgePattern;

import com.coop.devopsservice.entity.questionEntity.ShowQuestions;
import com.coop.devopsservice.mapper.QuestionMapper;

import java.util.List;

public abstract class QuestionFilter {
    Priority priority;
    protected String projectId;
    QuestionMapper questionMapper ;

    public QuestionFilter(Priority priority, String projectId, QuestionMapper questionMapper) {
        this.priority = priority;
        this.projectId = projectId;
        this.questionMapper = questionMapper;
    }

    public abstract List<ShowQuestions> showQuestions();
}
