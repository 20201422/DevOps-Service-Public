package com.coop.devopsservice.designPattern.lrx_singtonPattern;

import com.coop.devopsservice.entity.projectEntity.Project;
import com.coop.devopsservice.mapper.ProjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {

    private static volatile ProjectManager projectManager = null;
    private List<Project> projectList = null;
    private ProjectManager(){
        projectList = new ArrayList<Project>();
    }
    public static ProjectManager getInstance() {
        if (projectManager == null) {
            synchronized(ProjectManager.class) {
                if (projectManager == null) {
                    projectManager = new ProjectManager();
                }
            }
        }
        return projectManager;
    }
    //查询用户参与的项目
    public List<Project> showAllProjects(String userId,ProjectMapper projectMapper){
        return projectMapper.findProjects(userId);
    }
    public void addProject(Project project){projectList.add(project);}

    public void removeProject(Project project){projectList.remove(project);}
}
