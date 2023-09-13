package com.coop.devopsservice.designPattern.lrx_commandPattern;

import com.coop.devopsservice.mapper.IterationMapper;

public class AddQuestionCommand extends Command{
    AddQuestion addQuestion;
    private String questionId;
    private int iterationId;
    IterationMapper iterationMapper;

    public AddQuestionCommand(String questionId, int iterationId, IterationMapper iterationMapper) {
        this.questionId = questionId;
        this.iterationId = iterationId;
        this.iterationMapper = iterationMapper;
        this.addQuestion = new AddQuestion();
    }

    public AddQuestionCommand() {
    }

    @Override
    public int execute() {
        return addQuestion.doAction(questionId,iterationId,iterationMapper);
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getIterationId() {
        return iterationId;
    }

    public void setIterationId(int iterationId) {
        this.iterationId = iterationId;
    }
}
