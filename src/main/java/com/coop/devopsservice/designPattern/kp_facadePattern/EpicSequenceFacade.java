/**
 * @ClassName EpicSequenceFacade
 * @Author 24
 * @Date 2023/5/25 01:57
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_facadePattern;

import com.coop.devopsservice.entity.epicEntity.Epic;
import com.coop.devopsservice.serviceImpl.EpicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EpicSequenceFacade extends AbstractModelSequenceFacade {
    
    private EpicServiceImpl epicService;
    
    public EpicSequenceFacade() {
    }
    
    @Autowired
    public EpicSequenceFacade(EpicServiceImpl epicService) {
        this.epicService = epicService;
    }
    
    public EpicServiceImpl getEpicService() {
        return epicService;
    }
    
    public void setEpicService(EpicServiceImpl epicService) {
        this.epicService = epicService;
    }
    
    @Override
    public void changeSequence(Object epic) {
        Epic newEpic = (Epic) epic;
        int lastIndex = epicService.findLastEpic().getEpicIndex();  // 最后一个下标
//        epicService.lockEpic(); // 锁定表
        epicService.deleteEpicById(((Epic) epic).getEpicId(), newEpic.getProjectId());   // 删除要改变顺序的记录
        if (newEpic.getEpicIndex() == lastIndex) {  // 如果是要移动到最后一条
            newEpic.setEpicIndex(newEpic.getEpicIndex() + 1);   // 直接将下标加一
        } else {
            epicService.removeEpicAutoIncrement();  // 去掉表的自增
            epicService.removeEpicPrimaryKey(); // 去掉表的主键
            epicService.updateEpicIndex(newEpic.getEpicIndex());    // 改变之后记录的下标
            epicService.addEpicPrimaryKey();    // 添加主键
            epicService.addEpicAutoIncrement(); // 添加自增
        }
        epicService.addEpic(newEpic);   // 将新记录插入
//        epicService.unlockEpic();   // 解锁
    }
}

//    may the force be with you.
//    @ClassName   EpicSequenceFacade
//    Created by 24 on 2023/5/25.
