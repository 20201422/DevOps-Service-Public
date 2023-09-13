/**
 * @ClassName UserMapper
 * @Author 24
 * @Date 2023/5/14 17:03
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.mapper;

import com.coop.devopsservice.entity.userEntity.UserIdAndUserName;
import com.coop.devopsservice.entity.userEntity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findUsers();  // 查找所有用户
    
    @Select("select user.userId, userName \n" +
            "from user, project_and_user\n" +
            "where user.userId = project_and_user.userId and projectId = #{projectId}")
    List<UserIdAndUserName> findUsersOnlyIdAndName(String projectId);    // 查找用户的id和名字
    
    @Select("select * from user where userId = #{userId}")
    User findUserById(String userId);    // 查找一个用户根据id
    
    @Insert("insert into user values(#{userId}, #{userName}, #{userPassword}, #{userType}, #{userImage})")
    int addUser(User user);  // 添加一个用户
    
    @Delete("delete from user where id = #{userId}")
    int deleteUserById(String userId);   // 删除一个用户
    
//    @Options(useGeneratedKeys = true,keyProperty = "userId")    // 自动生成主键
    @Update("update user " +
            "set userId = #{userId}, userName = #{userName}, userPassword = #{userPassword}," +
            " userType = #{userType}, userImage = #{userImage} " +
            "where userId = #{userId}")
    int updateUser(User user);   // 更新用户信息

}

//    may the force be with you.
//    @ClassName   UserMapper
//    Created by 24 on 2023/5/14.
