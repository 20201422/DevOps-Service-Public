/**
 * @ClassName QuestionServiceImpl
 * @Author 24
 * @Date 2023/5/14 17:08
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.serviceImpl;

import com.coop.devopsservice.designPattern.lrx_bridgePattern.Priority;
import com.coop.devopsservice.designPattern.lrx_bridgePattern.QuestionFilter;
import com.coop.devopsservice.entity.questionEntity.Question;
import com.coop.devopsservice.entity.questionEntity.ShowQuestions;
import com.coop.devopsservice.mapper.QuestionMapper;
import com.coop.devopsservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionMapper questionMapper;

    public QuestionServiceImpl() {
    }

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    public QuestionMapper getQuestionMapper() {
        return questionMapper;
    }

    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public List<ShowQuestions> findQuestions(String projectId) { // 查找所有问题
        return questionMapper.findQuestions(projectId);
    }

    @Override
    public Question findQuestionByIndex(int questionIndex) {   // 查找某一个问题根据index
        return questionMapper.findQuestionByIndex(questionIndex);
    }


    @Override
    public List<ShowQuestions> findQuestionFree(String projectId) {
        return questionMapper.findQuestionFree(projectId);
    }

    @Override
    public List<ShowQuestions> findQuestionByStateAndPriority(String projectId, String questionState, String questionPriority) {  //用于桥接模式
        QuestionFilter questionFilter;
        Priority priority;


        return questionMapper.findQuestionByStateAndPriority(projectId,questionState,questionPriority);
    }

    @Override
    public Question findQuestionById(String questionId, String projectId) {   // 查找一个问题根据id
        return questionMapper.findQuestionById(questionId, projectId);
    }

    @Override
    public int addQuestion(Question question) { // 增加一个问题
        System.out.println(question);
        return questionMapper.addQuestion(question);
    }

    @Override
    public int deleteQuestionById(String questionId, String projectId) {  // 删除一个问题
        return questionMapper.deleteQuestionById(questionId, projectId);
    }

    @Override
    public int updateQuestion(Question question) {  // 更新问题信息
        return questionMapper.updateQuestion(question);
    }

    @Override
    public List<Question> findQuestionsByEpicId(String epicId, String projectId) {    // 根据史诗查找问题
        return questionMapper.findQuestionsByEpicId(epicId, projectId);
    }

    @Override
    public List<ShowQuestions> findQuestionByState(int iterationId,String state) {
        return questionMapper.findQuestionByState(iterationId,state);
    }

    @Override
    public List<ShowQuestions> findQuestionByIterationId(int iterationId) {
        return questionMapper.findQuestionByIterationId(iterationId);
    }

    @Override
    public Question findLastQuestion() { // 查询最后一个问题
        return questionMapper.findLastQuestion();
    }

    @Override
    public int lockQuestion() { // 锁定事务的写操作
        return questionMapper.lockQuestion();
    }

    @Override
    public int removeQuestionAutoIncrement() {  // 去掉问题自增
        return questionMapper.removeQuestionAutoIncrement();
    }

    @Override
    public int removeQuestionPrimaryKey() { // 去掉问题主键
        return questionMapper.removeQuestionPrimaryKey();
    }

    @Override
    public int updateQuestionIndex(int questionIndex) { // 更改问题后续下标
        return questionMapper.updateQuestionIndex(questionIndex);
    }

    @Override
    public int addQuestionPrimaryKey() {    // 添加问题主键
        return questionMapper.addQuestionPrimaryKey();
    }

    @Override
    public int addQuestionAutoIncrement() { // 添加问题自增
        return questionMapper.addQuestionAutoIncrement();
    }

    @Override
    public int unlockQuestion() {   // 解锁
        return questionMapper.unlockQuestion();
    }

}

//    may the force be with you.
//    @ClassName   QuestionServiceImpl
//    Created by 24 on 2023/5/14.
