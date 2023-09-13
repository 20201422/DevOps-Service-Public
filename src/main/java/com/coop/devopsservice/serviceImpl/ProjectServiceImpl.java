/**
 * @ClassName ProjectServiceImpl
 * @Author 24
 * @Date 2023/5/14 17:07
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.serviceImpl;

import com.coop.devopsservice.designPattern.lrx_singtonPattern.ProjectManager;
import com.coop.devopsservice.entity.projectEntity.Project;
import com.coop.devopsservice.mapper.ProjectMapper;
import com.coop.devopsservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    private ProjectMapper projectMapper;
    
    public ProjectServiceImpl() {
    }
    
    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }
    
    public ProjectMapper getProjectMapper() {
        return projectMapper;
    }
    
    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }
    
    @Override
    public List<Project> findProjects(String userId) {   // 查找所有用户
        ProjectManager projectManager = ProjectManager.getInstance();  //获取单例对象
        return projectManager.showAllProjects(userId,projectMapper);
    }
    
    @Override
    public Project findProjectById(String projectId) {  // 查找一个项目根据Id
        return projectMapper.findProjectById(projectId);
    }
    
    @Override
    public int addProject(Project project) {    // 增加一个项目
        return projectMapper.addProject(project);
    }
    
    @Override
    public int deleteProjectById(String projectId) {    // 删除一个项目
        return projectMapper.deleteProjectById(projectId);
    }
    
    @Override
    public int updateProject(Project project) { // 更新项目信息
        return projectMapper.updateProject(project);
    }
}

//    may the force be with you.
//    @ClassName   ProjectServiceImpl
//    Created by 24 on 2023/5/14.
