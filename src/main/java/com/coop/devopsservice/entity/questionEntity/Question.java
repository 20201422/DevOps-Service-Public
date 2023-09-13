/**
 * @ClassName Question
 * @Author 24
 * @Date 2023/4/20 20:31
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.questionEntity;

public class Question {
    
    private int questionIndex;
    private String questionId;
    private String questionName;
    private String questionDescribe;
    private String questionPriority;
    private String questionState;
    private String beginTime;
    private String endTime;
    private String projectId;
    private String userId;
    private String epicId;
    private int iterationId;
    
    public Question() {
    }
    
    public Question(int questionIndex, String questionId, String questionName, String questionDescribe,
                    String questionPriority, String questionState, String beginTime, String endTime,
                    String projectId, String userId, String epicId, int iterationId) {
        this.questionIndex = questionIndex;
        this.questionId = questionId;
        this.questionName = questionName;
        this.questionDescribe = questionDescribe;
        this.questionPriority = questionPriority;
        this.questionState = questionState;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.projectId = projectId;
        this.userId = userId;
        this.epicId = epicId;
        this.iterationId = iterationId;
    }
    
    public int getQuestionIndex() {
        return questionIndex;
    }
    
    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
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
    
    public String getQuestionDescribe() {
        return questionDescribe;
    }
    
    public void setQuestionDescribe(String questionDescribe) {
        this.questionDescribe = questionDescribe;
    }
    
    public String getQuestionPriority() {
        return questionPriority;
    }
    
    public void setQuestionPriority(String questionPriority) {
        this.questionPriority = questionPriority;
    }
    
    public String getQuestionState() {
        return questionState;
    }
    
    public void setQuestionState(String questionState) {
        this.questionState = questionState;
    }
    
    public String getBeginTime() {
        return beginTime;
    }
    
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public String getProjectId() {
        return projectId;
    }
    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getEpicId() {
        return epicId;
    }
    
    public void setEpicId(String epicId) {
        this.epicId = epicId;
    }
    
    public int getIterationId() {
        return iterationId;
    }
    
    public void setIterationId(int iterationId) {
        this.iterationId = iterationId;
    }
    
    @Override
    public String toString() {
        return "Question{" +
                "questionIndex=" + questionIndex +
                ", questionId='" + questionId + '\'' +
                ", questionName='" + questionName + '\'' +
                ", questionDescribe='" + questionDescribe + '\'' +
                ", questionPriority='" + questionPriority + '\'' +
                ", questionState='" + questionState + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", projectId='" + projectId + '\'' +
                ", userId='" + userId + '\'' +
                ", epicId='" + epicId + '\'' +
                ", iterationId='" + iterationId + '\'' +
                '}';
    }
}

//    may the force be with you.
//
//    Created by 24 on 2023/4/20.
