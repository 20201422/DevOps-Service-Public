/**
 * @ClassName QuestionToBeCompletedState
 * @Author 24
 * @Date 2023/5/22 16:51
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_statePattern;

import com.coop.devopsservice.serviceImpl.QuestionServiceImpl;

public class EpicToBeCompletedState extends EpicState {
    
    public EpicToBeCompletedState(QuestionServiceImpl questionService) {
        super(questionService);
    }
    
    @Override
    public String setQuestionState() {
        return "规划中";
    }
}

//    may the force be with you.
//    @ClassName   QuestionToBeCompletedState
//    Created by 24 on 2023/5/22.
