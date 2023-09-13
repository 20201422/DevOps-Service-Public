/**
 * @ClassName FastQuestion
 * @Author 24
 * @Date 2023/5/22 21:45
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_factoryPattern;

import com.coop.devopsservice.designPattern.kp_builderPattern.BuilderQuestion;
import com.coop.devopsservice.designPattern.kp_builderPattern.BuilderController;
import com.coop.devopsservice.designPattern.kp_builderPattern.FastQuestionBuilderQuestion;

public class FastQuestion implements FastModel {
    
    private String questionId;
    private String questionName;
    private String questionPriority;
    private String userId;
    private int iterationId;
    private String projectId;
    
    public FastQuestion() {
    }

    public FastQuestion(String questionId, String questionName, String questionPriority, String userId, int iterationId, String projectId) {
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
    public Object addFastModel() {
        
        BuilderQuestion builderQuestion
                = new FastQuestionBuilderQuestion(questionId, questionName, questionPriority, userId,iterationId ,projectId);  // 针对抽象建造者编程
        BuilderController builderController = new BuilderController();
        
        return builderController.construct(builderQuestion);    // 通过指挥者创建完整的建造者对象
    }
}

//    may the force be with you.
//    @ClassName   FastQuestion
//    Created by 24 on 2023/5/22.
