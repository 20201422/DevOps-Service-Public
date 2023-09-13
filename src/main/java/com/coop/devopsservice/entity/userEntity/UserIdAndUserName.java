/**
 * @ClassName IdAndName
 * @Author 24
 * @Date 2023/5/21 22:14
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.userEntity;

public class UserIdAndUserName {
    
    private String userId;
    private String userName;
    
    public UserIdAndUserName() {
    }
    
    public UserIdAndUserName(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
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
    
    @Override
    public String toString() {
        return "IdAndName{" +
                "id='" + userId + '\'' +
                ", name='" + userName + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   IdAndName
//    Created by 24 on 2023/5/21.
