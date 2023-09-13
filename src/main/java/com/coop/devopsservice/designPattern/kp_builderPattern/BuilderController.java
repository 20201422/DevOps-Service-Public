/**
 * @ClassName BuilderController
 * @Author 24
 * @Date 2023/5/22 20:50
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_builderPattern;

import com.coop.devopsservice.entity.questionEntity.Question;

public class BuilderController {
    
    public BuilderController() {
    }
    
    public Question construct(BuilderQuestion builderQuestion) {
        
        builderQuestion.buildQuestionId();  // 建造问题id
        builderQuestion.buildQuestionName();    // 建造问题名称
        builderQuestion.buildQuestionPriority();    // 建造问题优先级
        builderQuestion.buildUserId();  // 建造用户id
        builderQuestion.buildIterationId(); // 建造迭代id
        builderQuestion.buildProjectId();   // 建造项目id
        builderQuestion.buildQuestionState();   // 建造问题状态
        
        return builderQuestion.createQuestion();
    }
    
}

//    may the force be with you.
//    @ClassName   BuilderController
//    Created by 24 on 2023/5/22.
