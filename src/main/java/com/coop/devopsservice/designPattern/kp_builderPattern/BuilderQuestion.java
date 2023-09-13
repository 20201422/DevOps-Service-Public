/**
 * @ClassName BuilderQuestion
 * @Author 24
 * @Date 2023/5/22 20:51
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_builderPattern;

import com.coop.devopsservice.entity.questionEntity.Question;

public abstract class BuilderQuestion {
    
    protected Question question = new Question();
    
    public abstract void buildQuestionId();
    public abstract void buildQuestionName();
    public abstract void buildQuestionPriority();
    public abstract void buildUserId();
    public abstract void buildIterationId();
    public abstract void buildProjectId();
    public abstract void buildQuestionState();
    
    public Question createQuestion() {
        return question;
    }
    
}

//    may the force be with you.
//    @ClassName   BuilderQuestion
//    Created by 24 on 2023/5/22.
