/**
 * @ClassName EpicService
 * @Author 24
 * @Date 2023/5/14 17:04
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.service;

import com.coop.devopsservice.entity.epicEntity.Epic;
import com.coop.devopsservice.entity.epicEntity.EpicIdAndEpicName;

import java.util.List;

public interface EpicService {

    List<Epic> findEpics(String projectId);
    List<EpicIdAndEpicName> findEpicsOnlyIdAndName(String projectId);
    Epic findEpicByIndex(int epicIndex);
    Epic findEpicById(String epicId, String projectId);
    int addEpic(Epic epic);
    int deleteEpicById(String epicId, String projectId);
    int updateEpic(Epic epic);
    Epic findLastEpic();
    int lockEpic();
    int removeEpicAutoIncrement();
    int removeEpicPrimaryKey();
    int updateEpicIndex(int epicIndex);
    int addEpicPrimaryKey();
    int addEpicAutoIncrement();
    int unlockEpic();
}

//    may the force be with you.
//    @ClassName   EpicService
//    Created by 24 on 2023/5/14.
