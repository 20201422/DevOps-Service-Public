/**
 * @ClassName User
 * @Author 24
 * @Date 2023/4/20 20:30
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.userEntity;

public class User {
    
    private String userId;
    private String userName;
    private String userPassword;
    private String userType;
    private String userImage;
    
    public User() {
    }
    
    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    
    public User(String userId, String userName, String userPassword, String userType, String userImage) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userImage = userImage;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getUserImage() {
        return userImage;
    }
    
    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                ", userImage='" + userImage + '\'' +
                '}';
    }
}

//    may the force be with you.
//
//    Created by 24 on 2023/4/20.
