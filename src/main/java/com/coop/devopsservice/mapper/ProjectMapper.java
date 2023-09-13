/**
 * @ClassName ProjectMapper
 * @Author 24
 * @Date 2023/5/14 17:01
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.mapper;

import com.coop.devopsservice.entity.projectEntity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {
    
    @Select("select project.*\n" +
            "from project, project_and_user\n" +
            "where project.projectId = project_and_user.projectId and userId = #{userId}")
    List<Project> findProjects(String userId);   // 查找所有项目
    
    @Select("select * from project where projectId = #{projectId}")
    Project findProjectById(String id); // 查找某一个项目根据id
    
    @Insert("insert into project " +
            "values(#{projectId}, #{projectName}, #{projectDescribe})")
    int addProject(Project project);    // 增加一个项目
    
    @Delete("delete from project where projectId = #{projectId}")
    int deleteProjectById(String id);   // 删除一个项目
    
    @Update("update project " +
            "set projectId = #{projectId}, projectName = #{projectName}, projectDescribe = #{projectDescribe} " +
            "where projectId = #{projectId}")
    int updateProject(Project project); // 更新项目信息

}

//    may the force be with you.
//    @ClassName   ProjectMapper
//    Created by 24 on 2023/5/14.
