/**
 * @ClassName EpicList
 * @Author 24
 * @Date 2023/4/20 20:31
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.epicEntity;

import com.coop.devopsservice.entity.questionEntity.Question;

import java.util.ArrayList;
import java.util.List;

public class EpicList {

    private Epic epic;
    private List<Question> questions;
    private int index;
    
    public EpicList() {
    }
    
    public EpicList(Epic epic) {
        this.epic = epic;
    }
    
    public EpicList(Epic epic, List<Question> questions, int index) {
        this.epic = epic;
        this.questions = questions;
        this.index = index;
    }
    
    public Epic getEpic() {
        return epic;
    }
    
    public void setEpic(Epic epic) {
        this.epic = epic;
    }
    
    public List<Question> getQuestions() {
        return questions;
    }
    
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public List<Question> addQuestion(Question question) {  // 添加问题
        if (questions == null)
            questions = new ArrayList<>();
        questions.add(question);
        return questions;
    }
    
    public void removeQuestion(Question question) { // 移除问题
        if (questions != null) {
            questions.remove(question);
        }
    }
    
    @Override
    public String toString() {
        return "EpicList{" +
                "epic=" + epic +
                ", questions=" + questions +
                ", index=" + index +
                '}';
    }
}

//    may the force be with you.
//
//    Created by 24 on 2023/4/20.
