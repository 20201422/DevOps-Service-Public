/**
 * @ClassName UserController
 * @Author 24
 * @Date 2023/5/14 19:46
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.controller.userController;

import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.entity.userEntity.User;
import com.coop.devopsservice.serviceImpl.UserServiceImpl;
import com.coop.devopsservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ApiResult<?> findUsers() {    // 查找全部用户
        System.out.println("查询全部用户");
        return ApiResultHandler.success(userService.findUsers());
    }

    @GetMapping("/users/idAndName/{projectId}")
    public ApiResult<?> findUsersOnlyIdAndName(@PathVariable("projectId") String projectId) { // 查找用户的id和名字
        System.out.println("查询用户的id和名字");
        return ApiResultHandler.success(userService.findUsersOnlyIdAndName(projectId));
    }

    @GetMapping("/{userId}")
    public ApiResult<?> findUserById(@PathVariable("userId") String userId) {  // 根据id查找用户
        System.out.println("根据ID查找用户");
        return ApiResultHandler.success(userService.findUserById(userId));
    }

    @PostMapping("/add")
    public ApiResult<?> addUser(User user){    // 添加一个用户
        System.out.println("添加用户");
        user.setUserPassword(DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes()));    // MD5加密
        return ApiResultHandler.success(userService.addUser(user));
    }

    @DeleteMapping("/delete/{userId}")
    public ApiResult<?> deleteUserById(@PathVariable("userId") String userId) {    // 删除一个用户
        System.out.println("删除用户");
        return ApiResultHandler.success(userService.deleteById(userId));
    }

    @PutMapping("/update")
    public ApiResult<?> updateUser(User user) {    // 更新用户
        System.out.println("更新用户");
        user.setUserPassword(DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes()));    // MD5加密
        return ApiResultHandler.success(userService.updateUser(user));
    }
}

//    may the force be with you.
//    @ClassName   UserController
//    Created by 24 on 2023/5/14.
