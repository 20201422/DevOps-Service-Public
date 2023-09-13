/**
 * @ClassName Story
 * @Author 24
 * @Date 2023/4/20 20:31
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.storyMapEntity;

import com.coop.devopsservice.entity.epicEntity.EpicList;

import java.util.ArrayList;
import java.util.List;

public class StoryMap {
    
    private List<EpicList> epics;
    
    public StoryMap() {
    }
    
    public StoryMap(List<EpicList> epics) {
        this.epics = epics;
    }
    
    public List<EpicList> getEpics() {
        return epics;
    }
    
    public void setEpics(List<EpicList> epics) {
        this.epics = epics;
    }
    
    public List<EpicList> addEpics(List<EpicList> epics) {
        if (this.epics == null)
            this.epics = new ArrayList<>();
        this.epics.addAll(epics);
        return this.epics;
    }
    
    public void removeEpics(List<EpicList> epics) {
        if (this.epics != null)
            this.epics.removeAll(epics);
    }
    
    @Override
    public String toString() {
        return "Story{" +
                "epics=" + epics +
                '}';
    }
}

//    may the force be with you.
//
//    Created by 24 on 2023/4/20.
