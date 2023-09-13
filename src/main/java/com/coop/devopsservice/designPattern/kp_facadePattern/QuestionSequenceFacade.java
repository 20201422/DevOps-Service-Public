/**
 * @ClassName QuestionSequenceFacade
 * @Author 24
 * @Date 2023/5/25 01:57
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_facadePattern;

import com.coop.devopsservice.entity.questionEntity.Question;
import com.coop.devopsservice.serviceImpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionSequenceFacade extends AbstractModelSequenceFacade {
    
    private QuestionServiceImpl questionService;
    
    public QuestionSequenceFacade() {
    }
    
    @Autowired
    public QuestionSequenceFacade(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }
    
    public QuestionServiceImpl getQuestionService() {
        return questionService;
    }
    
    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }
    
    @Override
    public void changeSequence(Object question) {
        Question newQuestion = (Question) question;
        int lastIndex = questionService.findLastQuestion().getQuestionIndex();  // 最后一个下标
        
//        questionService.lockQuestion(); // 锁定表
        questionService.deleteQuestionById(((Question) question).getQuestionId()
                , ((Question) question).getProjectId());   // 删除要改变顺序的记录
        if (newQuestion.getQuestionIndex() == lastIndex) {  // 如果是要移动到最后一条
            newQuestion.setQuestionIndex(newQuestion.getQuestionIndex() + 1);   // 直接将下标加一
        } else {
            questionService.removeQuestionAutoIncrement();  // 去掉表的自增
            questionService.removeQuestionPrimaryKey(); // 去掉表的主键
            questionService.updateQuestionIndex(newQuestion.getQuestionIndex());    // 改变之后记录的下标
            questionService.addQuestionPrimaryKey();    // 添加主键
            questionService.addQuestionAutoIncrement(); // 添加自增
        }
        questionService.addQuestion(newQuestion);   // 将新记录插入
//        questionService.unlockQuestion();   // 解锁
    }
}

//    may the force be with you.
//    @ClassName   QuestionSequenceFacade
//    Created by 24 on 2023/5/25.
