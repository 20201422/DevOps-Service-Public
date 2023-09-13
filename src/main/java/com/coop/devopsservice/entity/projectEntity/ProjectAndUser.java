/**
 * @ClassName ProjectAndUser
 * @Author 24
 * @Date 2023/5/14 20:08
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.projectEntity;

public class ProjectAndUser {
    
    private int projectAndUserId;
    private String projectId;
    private String userId;
    
    public ProjectAndUser() {
    }
    
    public ProjectAndUser(int projectAndUserId, String projectId, String userId) {
        this.projectAndUserId = projectAndUserId;
        this.projectId = projectId;
        this.userId = userId;
    }
    
    public int getProjectAndUserId() {
        return projectAndUserId;
    }
    
    public void setProjectAndUserId(int projectAndUserId) {
        this.projectAndUserId = projectAndUserId;
    }
    
    public String getProjectId() {
        return projectId;
    }
    
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Override
    public String toString() {
        return "ProjectAndUser{" +
                "projectAndUserId=" + projectAndUserId +
                ", projectId='" + projectId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   ProjectAndUser
//    Created by 24 on 2023/5/14.
