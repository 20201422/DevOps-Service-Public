/**
 * @ClassName EpicMapper
 * @Author 24
 * @Date 2023/5/14 17:00
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.mapper;

import com.coop.devopsservice.entity.epicEntity.Epic;
import com.coop.devopsservice.entity.epicEntity.EpicIdAndEpicName;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EpicMapper {

    @Select("select * from epic where projectId = #{projectId}")
    List<Epic> findEpics(String projectId);   // 查找所有史诗

    @Select("select epicId, epicName from epic where projectId = #{projectId}")
    List<EpicIdAndEpicName> findEpicsOnlyIdAndName(String projectId);   // 查找史诗的id和名字

    @Select("select * from epic where epicIndex = #{epicIndex}")
    Epic findEpicByIndex(int epicIndex); // 查找一个史诗根据index

    @Select("select * from epic where epicId = #{epicId} and projectId = #{projectId}")
    Epic findEpicById(String epicId, String projectId);   // 查找一个史诗根据id

    @Insert("insert into epic values(#{epicIndex}, #{epicId}, #{epicName}, #{epicDescribe}, #{epicPriority}, #{epicState}, #{projectId})")
    int addEpic(Epic epic);     // 增加一个史诗

    @Delete("delete from epic where epicId = #{epicId} and projectId = #{projectId}")
    int deleteEpicById(String epicId, String projectId);  // 删除一个史诗

    @Update("update epic " +
            "set epicId = #{epicId}, epicName = #{epicName}, epicDescribe = #{epicDescribe}, " +
            "epicPriority = #{epicPriority}, epicState = #{epicState} " +
            "where epicIndex = #{epicIndex}")
    int updateEpic(Epic epic);  // 更新史诗信息

    @Select("select * from epic where epicIndex =(select max(epicIndex) from epic)")
    Epic findLastEpic(); // 查询最后一个史诗

    @Update("lock tables epic write")
    int lockEpic(); // 锁定事务的写操作

    @Update("alter table epic modify epicIndex int")
    int removeEpicAutoIncrement(); // 去掉史诗自增

    @Update("alter table epic drop primary key")
    int removeEpicPrimaryKey(); // 去掉史诗主键

    @Update("update epic set epicIndex = epicIndex + 1 where epicIndex >= #{epicIndex}")
    int updateEpicIndex(int epicIndex);  // 更改史诗后续下标

    @Update("alter table epic add primary key (epicIndex)")
    int addEpicPrimaryKey();    // 添加史诗主键

    @Update("alter table epic modify epicIndex int auto_increment")
    int addEpicAutoIncrement(); // 添加史诗自增

    @Update("commit")
    int unlockEpic();   // 解锁
}

//    may the force be with you.
//    @ClassName   EpicMapper
//    Created by 24 on 2023/5/14.
