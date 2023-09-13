/**
 * @ClassName QuestionUnderwayState
 * @Author 24
 * @Date 2023/5/22 16:52
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_statePattern;


import com.coop.devopsservice.serviceImpl.QuestionServiceImpl;

public class EpicUnderwayState extends EpicState {
    
    public EpicUnderwayState(QuestionServiceImpl questionService) {
        super(questionService);
    }
    
    @Override
    public String setQuestionState() {
        return "实现中";
    }
}

//    may the force be with you.
//    @ClassName   QuestionUnderwayState
//    Created by 24 on 2023/5/22.
