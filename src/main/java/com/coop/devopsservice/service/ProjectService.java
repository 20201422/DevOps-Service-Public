/**
 * @ClassName ProjectService
 * @Author 24
 * @Date 2023/5/14 17:05
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.service;

import com.coop.devopsservice.entity.projectEntity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findProjects(String userId);
    Project findProjectById(String projectId);
    int addProject(Project project);
    int deleteProjectById(String projectId);
    int updateProject(Project project);

}

//    may the force be with you.
//    @ClassName   ProjectService
//    Created by 24 on 2023/5/14.
