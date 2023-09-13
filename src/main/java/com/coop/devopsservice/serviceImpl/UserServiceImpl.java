/**
 * @ClassName UserServiceImpl
 * @Author 24
 * @Date 2023/5/14 17:10
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.serviceImpl;

import com.coop.devopsservice.entity.userEntity.UserIdAndUserName;
import com.coop.devopsservice.entity.userEntity.User;
import com.coop.devopsservice.mapper.UserMapper;
import com.coop.devopsservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    private UserMapper userMapper;
    
    public UserServiceImpl() {
    }
    
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    public UserMapper getUserMapper() {
        return userMapper;
    }
    
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    @Override
    public List<User> findUsers() {   // 查找所有用户
        return userMapper.findUsers();
    }
    
    @Override
    public List<UserIdAndUserName> findUsersOnlyIdAndName(String projectId) {    // 查找用户的id和名字
        return userMapper.findUsersOnlyIdAndName(projectId);
    }
    
    @Override
    public User findUserById(String userId) {   // 根据id查找用户
        return userMapper.findUserById(userId);
    }
    
    @Override
    public int addUser(User user) { // 添加一个用户
        return userMapper.addUser(user);
    }
    
    @Override
    public int deleteById(String userId) {  // 删除一个用户
        return userMapper.deleteUserById(userId);
    }
    
    @Override
    public int updateUser(User user) {  // 更新一个用户
        System.out.println(user.toString());
        return userMapper.updateUser(user);
    }
}

//    may the force be with you.
//    @ClassName   UserServiceImpl
//    Created by 24 on 2023/5/14.
