/**
 * @ClassName EpicIdAndEpicName
 * @Author 24
 * @Date 2023/5/21 22:22
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.epicEntity;

public class EpicIdAndEpicName {
    
    private String epicId;
    private String epicName;
    
    public EpicIdAndEpicName() {
    }
    
    public EpicIdAndEpicName(String epicId, String epicName) {
        this.epicId = epicId;
        this.epicName = epicName;
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
    
    @Override
    public String toString() {
        return "EpicIdAndEpicName{" +
                "epicId='" + epicId + '\'' +
                ", epicName='" + epicName + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   EpicIdAndEpicName
//    Created by 24 on 2023/5/21.
