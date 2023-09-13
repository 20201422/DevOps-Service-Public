/**
 * @ClassName StoryMapFacade
 * @Author 24
 * @Date 2023/5/22 20:20
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_facadePattern;

import com.coop.devopsservice.entity.epicEntity.Epic;
import com.coop.devopsservice.entity.epicEntity.EpicList;
import com.coop.devopsservice.entity.questionEntity.Question;
import com.coop.devopsservice.entity.storyMapEntity.StoryMap;
import com.coop.devopsservice.serviceImpl.EpicServiceImpl;
import com.coop.devopsservice.serviceImpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class StoryMapFacade extends AbstractStoryMapFacade {
    
    private EpicServiceImpl epicService;
    private QuestionServiceImpl questionService;
    
    public StoryMapFacade() {
    }
    
    @Autowired
    public StoryMapFacade(EpicServiceImpl epicService, QuestionServiceImpl questionService) {
        this.epicService = epicService;
        this.questionService = questionService;
    }
    
    @Override
    public StoryMap getStoryMap(String projectId) {
        
        List<EpicList> epicLists = new ArrayList<>();
        
        List<Epic> epics =  epicService.findEpics(projectId);    // 查找所有史诗
        
        for (Epic epic : epics) {
            List<Question> questions = questionService.findQuestionsByEpicId(epic.getEpicId(), projectId); // 根据史诗查找问题
            
            questions.sort(Comparator.comparingInt(Question::getQuestionIndex));    // 按照index排序
            
            epicLists.add(new EpicList(epic, questions, epic.getEpicIndex()));
        }
        
        epicLists.sort(Comparator.comparing(EpicList::getIndex));   // 按照index排序
        
        return new StoryMap(epicLists);
    }
}

//    may the force be with you.
//    @ClassName   StoryMapFacade
//    Created by 24 on 2023/5/22.
