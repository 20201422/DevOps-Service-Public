package com.coop.devopsservice;

import com.coop.devopsservice.controller.epicController.EpicController;
import com.coop.devopsservice.controller.questionController.QuestionController;
import com.coop.devopsservice.controller.userController.UserController;
import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.entity.epicEntity.Epic;
import com.coop.devopsservice.entity.questionEntity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DevOpsServiceApplicationTests {

    @Autowired
    private UserController userController;
    @Autowired
    private QuestionController questionController;
    @Autowired
    private EpicController epicController;

    @Test
    void contextLoads() {

//        User user = new User("20201419", "慧强", "123456", "组员", "hq.jpeg");
//        User user = new User("20201420", "滔滔", "123456", "组员", "tt.jpeg");
//        User user = new User("20201422", "堃芃", "123456", "组长", "kp.jpeg");
//        User user = new User("20201423", "瑞祥", "123456", "组员", "rx.jpeg");
//        ApiResult apiResult = userController.updateUser(user);
//        assertEquals(200, apiResult.getCode());

//        ApiResult api = questionController.addFastQuestion("2429-3-2", "工厂模式",
//                "低", "20201422", "2429");
//        assertEquals(200, api.getCode());
    }

}
