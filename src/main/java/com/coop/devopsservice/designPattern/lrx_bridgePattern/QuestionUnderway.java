package com.coop.devopsservice.designPattern.lrx_bridgePattern;

import com.coop.devopsservice.entity.questionEntity.ShowQuestions;
import com.coop.devopsservice.mapper.QuestionMapper;

import java.util.List;

public class QuestionUnderway extends QuestionFilter{
    public QuestionUnderway(Priority priority, String projectId, QuestionMapper questionMapper) {
        super(priority, projectId, questionMapper);
    }

    @Override
    public List<ShowQuestions> showQuestions() {
        return questionMapper.findQuestionByStateAndPriority(projectId,"实现中",priority.getPriority());
        //System.out.println("问题筛选条件为----状态：实现中 优先级："+super.priority.getPriority());
    }
}
