package com.coop.devopsservice.designPattern.lrx_bridgePattern;

import com.coop.devopsservice.entity.questionEntity.ShowQuestions;
import com.coop.devopsservice.mapper.QuestionMapper;

import java.util.List;

public class QuestionToBeCompleted extends QuestionFilter{
    public QuestionToBeCompleted(Priority priority, String projectId, QuestionMapper questionMapper) {
        super(priority, projectId, questionMapper);
    }

    @Override
    public List<ShowQuestions> showQuestions() {
        return questionMapper.findQuestionByStateAndPriority(projectId,"规划中",priority.getPriority());
        //System.out.println("问题筛选条件为----状态：规划中 优先级："+super.priority.getPriority());
    }
}
