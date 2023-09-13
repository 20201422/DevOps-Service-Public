/**
 * @ClassName AbstractStoryMapFacade
 * @Author 24
 * @Date 2023/5/22 20:19
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_facadePattern;

import com.coop.devopsservice.entity.storyMapEntity.StoryMap;

public abstract class AbstractStoryMapFacade {
    
    public abstract StoryMap getStoryMap(String projectId);
    
}

//    may the force be with you.
//    @ClassName   AbstractStoryMapFacade
//    Created by 24 on 2023/5/22.
