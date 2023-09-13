/**
 * @ClassName EpicServiceImpl
 * @Author 24
 * @Date 2023/5/14 17:07
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.serviceImpl;

import com.coop.devopsservice.entity.epicEntity.Epic;
import com.coop.devopsservice.entity.epicEntity.EpicIdAndEpicName;
import com.coop.devopsservice.mapper.EpicMapper;
import com.coop.devopsservice.service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicServiceImpl implements EpicService {

    private EpicMapper epicMapper;

    public EpicServiceImpl() {
    }

    @Autowired
    public EpicServiceImpl(EpicMapper epicMapper) {
        this.epicMapper = epicMapper;
    }

    public EpicMapper getEpicMapper() {
        return epicMapper;
    }

    public void setEpicMapper(EpicMapper epicMapper) {
        this.epicMapper = epicMapper;
    }

    @Override
    public List<Epic> findEpics(String projectId) { // 查找所有史诗
        return epicMapper.findEpics(projectId);
    }

    @Override
    public List<EpicIdAndEpicName> findEpicsOnlyIdAndName(String projectId) {   // 查找史诗的id和名字
        return epicMapper.findEpicsOnlyIdAndName(projectId);
    }

    @Override
    public Epic findEpicByIndex(int epicIndex) { // 查找某一个问题根据index
        return epicMapper.findEpicByIndex(epicIndex);
    }


    @Override
    public Epic findEpicById(String epicId, String projectId) {   // 查找一个史诗根据Id
        return epicMapper.findEpicById(epicId, projectId);
    }

    @Override
    public int addEpic(Epic epic) { // 增加一个史诗
        return epicMapper.addEpic(epic);
    }

    @Override
    public int deleteEpicById(String epicId, String projectId) {  // 删除一个史诗
        return epicMapper.deleteEpicById(epicId, projectId);
    }

    @Override
    public int updateEpic(Epic epic) {  // 更新史诗信息
        return epicMapper.updateEpic(epic);
    }

    @Override
    public Epic findLastEpic() { // 查询最后一个史诗
        return epicMapper.findLastEpic();
    }

    @Override
    public int lockEpic() { // 锁定事务的写操作
        return epicMapper.lockEpic();
    }

    @Override
    public int removeEpicAutoIncrement() {  // 去掉史诗自增
        return epicMapper.removeEpicAutoIncrement();
    }

    @Override
    public int removeEpicPrimaryKey() { // 去掉史诗主键
        return epicMapper.removeEpicPrimaryKey();
    }

    @Override
    public int updateEpicIndex(int epicIndex) { // 更改史诗后续下标
        return epicMapper.updateEpicIndex(epicIndex);
    }

    @Override
    public int addEpicPrimaryKey() {    // 添加史诗主键
        return epicMapper.addEpicPrimaryKey();
    }

    @Override
    public int addEpicAutoIncrement() { // 添加史诗自增
        return epicMapper.addEpicAutoIncrement();
    }

    @Override
    public int unlockEpic() {   // 解锁
        return epicMapper.unlockEpic();
    }
}

//    may the force be with you.
//    @ClassName   EpicServiceImpl
//    Created by 24 on 2023/5/14.
