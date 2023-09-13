/**
 * @ClassName FastQuestionFactory
 * @Author 24
 * @Date 2023/5/22 21:45
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_factoryPattern;

public class FastQuestionFactory implements FastModelFactory {
    
    private String questionId;
    private String questionName;
    private String questionPriority;
    private String userId;
    private int iterationId;
    private String projectId;
    
    public FastQuestionFactory() {
    }
    
    public FastQuestionFactory(String questionId, String questionName, String questionPriority,
                               String userId,int iterationId, String projectId) {
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
    public FastModel createFastModel() {
        return new FastQuestion(questionId, questionName, questionPriority, userId, iterationId,projectId);
    }
}

//    may the force be with you.
//    @ClassName   FastQuestionFactory
//    Created by 24 on 2023/5/22.
