/**
 * @ClassName QuestionService
 * @Author 24
 * @Date 2023/5/14 17:05
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.service;

import com.coop.devopsservice.entity.questionEntity.Question;
import com.coop.devopsservice.entity.questionEntity.ShowQuestions;

import java.util.List;

public interface QuestionService {

    List<ShowQuestions> findQuestions(String projectId);
    List<ShowQuestions> findQuestionFree(String projectId);
    List<ShowQuestions> findQuestionByStateAndPriority(String projectId,String questionState,String questionPriority);
    Question findQuestionByIndex(int questionIndex);
    Question findQuestionById(String questionId, String projectId);
    int addQuestion(Question question);
    int deleteQuestionById(String questionId, String projectId);
    int updateQuestion(Question question);
    List<Question> findQuestionsByEpicId(String epicId, String projectId);
    List<ShowQuestions> findQuestionByState(int iterationId,String state);
    List<ShowQuestions> findQuestionByIterationId(int iterationId);
    Question findLastQuestion();
    int lockQuestion();
    int removeQuestionAutoIncrement();
    int removeQuestionPrimaryKey();
    int updateQuestionIndex(int questionIndex);
    int addQuestionPrimaryKey();
    int addQuestionAutoIncrement();
    int unlockQuestion();
}

//    may the force be with you.
//    @ClassName   QuestionService
//    Created by 24 on 2023/5/14.
