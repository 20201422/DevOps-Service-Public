/**
 * @ClassName CompletedQuestion
 * @Author 24
 * @Date 2023/5/22 19:22
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_flyweightPattern;

public class CompletedQuestion extends QuestionState {
    
    public CompletedQuestion() {
    }
    
    @Override
    public String getQuestionState() {
        return "已实现";
    }
}

//    may the force be with you.
//    @ClassName   CompletedQuestion
//    Created by 24 on 2023/5/22.
