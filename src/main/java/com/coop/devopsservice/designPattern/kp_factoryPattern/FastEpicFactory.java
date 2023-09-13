/**
 * @ClassName FastEpicFactory
 * @Author 24
 * @Date 2023/5/22 21:45
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.designPattern.kp_factoryPattern;

public class FastEpicFactory implements FastModelFactory {
    
    public FastEpicFactory() {
    }
    
    @Override
    public FastModel createFastModel() {
        return new FastEpic();
    }
}

//    may the force be with you.
//    @ClassName   FastEpicFactory
//    Created by 24 on 2023/5/22.
