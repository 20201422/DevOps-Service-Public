/**
 * @ClassName Project
 * @Author 24
 * @Date 2023/4/20 20:31
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.projectEntity;

import com.coop.devopsservice.entity.userEntity.User;

import java.util.ArrayList;
import java.util.List;

public class Project {
    
    private String projectId;
    private String projectName;
    private String projectDescribe;
    private String projectState;
    
    public Project() {
    }
    
    public Project(String projectId, String projectName, String projectDescribe, String projectState) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescribe = projectDescribe;
        this.projectState = projectState;
    }
    
    public String getProjectId() {
        return projectId;
    }
    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getProjectDescribe() {
        return projectDescribe;
    }
    
    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe;
    }
    
    public String getProjectState() {
        return projectState;
    }
    
    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }
    
    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectDescribe='" + projectDescribe + '\'' +
                ", projectState='" + projectState + '\'' +
                '}';
    }
}

//    may the force be with you.
//
//    Created by 24 on 2023/4/20.
