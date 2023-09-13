/**
 * @ClassName QuestionMapper
 * @Author 24
 * @Date 2023/5/14 17:01
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.mapper;

import com.coop.devopsservice.entity.questionEntity.Question;
import com.coop.devopsservice.entity.questionEntity.ShowQuestions;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Select("select question.*, userName\n" +
            "from question\n" +
            "left outer join user on question.userId = user.userId\n" +
            "where projectId = #{projectId}")
    List<ShowQuestions> findQuestions(String projectId); // 查找所有问题
    @Select("select question.*, userName\n" +
            "from question\n" +
            "left outer join user on question.userId = user.userId\n" +
            "where projectId = #{projectId} and (iterationId is null OR iterationId=0)")
    List<ShowQuestions> findQuestionFree(String projectId);  //查询所有没有进迭代的问题

    @Select("select question.*, userName\n" +
            "from question\n" +
            "left outer join user on question.userId = user.userId\n" +
            "where projectId = #{projectId} and questionState = #{questionState} and questionPriority = #{questionPriority}")
    List<ShowQuestions> findQuestionByStateAndPriority(String projectId,String questionState,String questionPriority);  //根据问题的状态和优先级查询问题,用于桥接模式
    @Select("select * from question where questionIndex = #{questionIndex}")
    Question findQuestionByIndex(int questionIndex);  // 查找某一个问题根据index

    @Select("select * from question where questionId = #{questionId} and projectId = #{projectId}")
    Question findQuestionById(String questionId, String projectId);   // 查找某一个问题根据id

    @Insert("insert into question " +
            "values(#{questionIndex}, #{questionId}, #{questionName}, #{questionDescribe}, #{questionPriority}," +
            " #{questionState}, #{beginTime}, #{endTime}, #{projectId}, #{userId}, #{epicId}, #{iterationId})")
    int addQuestion(Question question); // 增加一个问题

    @Delete("delete from question where questionId = #{questionId} and projectId = #{projectId}")
    int deleteQuestionById(String questionId, String projectId);  // 删除一个问题

    @Update("update question " +
            "set questionId = #{questionId}, questionName = #{questionName}, questionDescribe = #{questionDescribe}, " +
            "questionPriority = #{questionPriority}, questionState = #{questionState}, " +
            "beginTime = #{beginTime}, endTime = #{endTime}, userId = #{userId}, " +
            "epicId = #{epicId}, iterationId = #{iterationId} " +
            "where questionIndex = #{questionIndex}")
    int updateQuestion(Question question);  // 更新问题信息

    @Select("select * from question where epicId = #{epicId} and projectId = #{projectId}")
    List<Question> findQuestionsByEpicId(String epicId, String projectId);    // 根据史诗查找问题

    @Select("select question.*, userName\n" +
            "from question\n" +
            "left outer join user on question.userId = user.userId\n" +
            "where questionState = #{state} and iterationId = #{iterationId}")
    List<ShowQuestions> findQuestionByState(int iterationId,String state);

    @Select("select question.*, userName\n" +
            "from question\n" +
            "left outer join user on question.userId = user.userId\n" +
            "where iterationId = #{iterationId}")
    List<ShowQuestions> findQuestionByIterationId(int iterationId);

    @Select("select * from question where questionIndex =(select max(questionIndex) from question)")
    Question findLastQuestion(); // 查询最后一个问题

    @Update("lock tables question write")
    int lockQuestion(); // 锁定事务的写操作

    @Update("alter table question modify questionIndex int")
    int removeQuestionAutoIncrement(); // 去掉问题自增

    @Update("alter table question drop primary key")
    int removeQuestionPrimaryKey(); // 去掉问题主键

    @Update("update question set questionIndex = questionIndex + 1 where questionIndex >= #{questionIndex}")
    int updateQuestionIndex(int questionIndex);  // 更改问题后续下标

    @Update("alter table question add primary key (questionIndex)")
    int addQuestionPrimaryKey();    // 添加问题主键

    @Update("alter table question modify questionIndex int auto_increment")
    int addQuestionAutoIncrement(); // 添加问题自增

    @Update("commit")
    int unlockQuestion();   // 解锁
}

//    may the force be with you.
//    @ClassName   QuestionMapper
//    Created by 24 on 2023/5/14.
