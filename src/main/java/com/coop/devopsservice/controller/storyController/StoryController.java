/**
 * @ClassName StoryController
 * @Author 24
 * @Date 2023/5/22 19:33
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.controller.storyController;

import com.coop.devopsservice.designPattern.kp_facadePattern.AbstractStoryMapFacade;
import com.coop.devopsservice.designPattern.kp_facadePattern.StoryMapFacade;
import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("story")
public class StoryController {

    private AbstractStoryMapFacade storyMapFacade = new StoryMapFacade();

    public StoryController() {
    }

    @Autowired
    public StoryController(AbstractStoryMapFacade storyMapFacade) {
        this.storyMapFacade = storyMapFacade;
    }

    public AbstractStoryMapFacade getStoryMapFacade() {
        return storyMapFacade;
    }

    public void setStoryMapFacade(AbstractStoryMapFacade storyMapFacade) {
        this.storyMapFacade = storyMapFacade;
    }

    @GetMapping("/{projectId}")
    public ApiResult<?> showStoryMap(@PathVariable("projectId") String projectId) {    // 查找故事地图
        System.out.println("查询故事地图");

        return ApiResultHandler.success(storyMapFacade.getStoryMap(projectId));
    }

}

//    may the force be with you.
//    @ClassName   StoryController
//    Created by 24 on 2023/5/22.
