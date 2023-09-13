/**
 * @ClassName QuestionBuilder
 * @Author 24
 * @Date 2023/5/22 20:51
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_builderPattern;

public class FastQuestionBuilderQuestion extends BuilderQuestion {
    
    private String questionId;
    private String questionName;
    private String questionPriority;
    private String userId;
    private int iterationId;
    private String projectId;
    
    public FastQuestionBuilderQuestion() {
    }

    public FastQuestionBuilderQuestion(String questionId, String questionName, String questionPriority, String userId, int iterationId, String projectId) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.questionPriority = questionPriority;
        this.userId = userId;
        this.iterationId = iterationId;
        this.projectId = projectId;
    }

    public String getQuestionId() {
        return questionId;
    }
    
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    
    public String getQuestionName() {
        return questionName;
    }
    
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }
    
    public String getQuestionPriority() {
        return questionPriority;
    }
    
    public void setQuestionPriority(String questionPriority) {
        this.questionPriority = questionPriority;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIterationId() {
        return iterationId;
    }

    public void setIterationId(int iterationId) {
        this.iterationId = iterationId;
    }

    public String getProjectId() {
        return projectId;
    }
    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    
    @Override
    public void buildQuestionId() {
        question.setQuestionId(questionId);
    }
    
    @Override
    public void buildQuestionName() {
        question.setQuestionName(questionName);
    }
    
    @Override
    public void buildQuestionPriority() {
        question.setQuestionPriority(questionPriority);
    }
    
    @Override
    public void buildUserId() {
        question.setUserId(userId);
    }

    @Override
    public void buildIterationId() {
        question.setIterationId(iterationId);
    }

    @Override
    public void buildProjectId() {
        question.setProjectId(projectId);
    }
    
    @Override
    public void buildQuestionState() {
        question.setQuestionState("规划中");
    }
}

//    may the force be with you.
//    @ClassName   QuestionBuilder
//    Created by 24 on 2023/5/22.
