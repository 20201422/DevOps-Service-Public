/**
 * @ClassName QuestionFactory
 * @Author 24
 * @Date 2023/5/22 19:15
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_flyweightPattern;

import java.util.Hashtable;


public class QuestionFactory {
    private static QuestionFactory instance = new QuestionFactory();
    private static Hashtable hashtable; // 使用Hashtable来存储享元对象，充当享元池
    
    public QuestionFactory() {
        hashtable = new Hashtable();
        QuestionState toBeCompleted, underway, completed;
        
        toBeCompleted = new ToBeCompletedQuestion();
        underway = new UnderwayQuestion();
        completed = new CompletedQuestion();
        
        hashtable.put("规划中", toBeCompleted);
        hashtable.put("实现中", underway);
        hashtable.put("已实现", completed);
    }
    
    public static void setInstance(QuestionFactory instance) {
        QuestionFactory.instance = instance;
    }
    
    public static Hashtable getHashtable() {
        return hashtable;
    }
    
    public static void setHashtable(Hashtable hashtable) {
        QuestionFactory.hashtable = hashtable;
    }
    
    //返回享元工厂类的唯一实例
    public static QuestionFactory getInstance() {return instance;}
    
    //通过key来获取存储在Hashtable中的享元对象
    public static QuestionState getQuestionState(String key) {

        if (hashtable.containsKey(key)) {
            return (QuestionState) hashtable.get(key);
        }
        else
            return null;
    }
}

//    may the force be with you.
//    @ClassName   QuestionFactory
//    Created by 24 on 2023/5/22.
