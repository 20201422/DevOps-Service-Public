/**
 * @ClassName FastEpic
 * @Author 24
 * @Date 2023/5/22 21:45
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_factoryPattern;

import com.coop.devopsservice.entity.epicEntity.Epic;

public class FastEpic implements FastModel {
    
    private String epicId;
    private String epicName;
    private String epicPriority;
    private String userId;
    
    public FastEpic() {
    }
    
    public FastEpic(String epicId, String epicName, String epicPriority, String userId) {
        this.epicId = epicId;
        this.epicName = epicName;
        this.epicPriority = epicPriority;
        this.userId = userId;
    }
    
    public String getEpicId() {
        return epicId;
    }
    
    public void setEpicId(String epicId) {
        this.epicId = epicId;
    }
    
    public String getEpicName() {
        return epicName;
    }
    
    public void setEpicName(String epicName) {
        this.epicName = epicName;
    }
    
    public String getEpicPriority() {
        return epicPriority;
    }
    
    public void setEpicPriority(String epicPriority) {
        this.epicPriority = epicPriority;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Override
    public Object addFastModel() {
        return new Epic();
    }
}

//    may the force be with you.
//    @ClassName   FastEpic
//    Created by 24 on 2023/5/22.
