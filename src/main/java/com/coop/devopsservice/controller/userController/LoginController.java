/**
 * @ClassName LoginController
 * @Author 24
 * @Date 2023/5/16 14:42
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.controller.userController;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.entity.userEntity.User;
import com.coop.devopsservice.serviceImpl.UserServiceImpl;
import com.coop.devopsservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {

    private UserServiceImpl userService;

    public LoginController() {
    }

    @Autowired
    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResult<?> login(@RequestBody User user) {
        user.setUserPassword(DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes()));    // MD5加密
        User userDB = userService.findUserById(user.getUserId());   // 查找用户

        if (ObjectUtils.isEmpty(userDB)) {  // 用户不存在
            return ApiResultHandler.buildApiResult(200, "用户不存在", userDB);
        } else {    // 存在用户
            if (Objects.equals(userDB.getUserPassword(), user.getUserPassword())) { // 密码正确
                return ApiResultHandler.buildApiResult(200, "登录成功", userDB);
            } else {    // 密码错误
                return ApiResultHandler.buildApiResult(200, "密码错误", userDB);
            }
        }
    }
}

//    may the force be with you.
//    @ClassName   LoginController
//    Created by 24 on 2023/5/16.
