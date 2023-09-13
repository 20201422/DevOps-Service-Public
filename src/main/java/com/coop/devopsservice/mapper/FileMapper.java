/**
 * @ClassName FileMapper
 * @Author 24
 * @Date 2023/5/26 22:24
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.mapper;

import com.coop.devopsservice.entity.fileEntity.FileEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("select * from file where projectId = #{projectId}")
    List<FileEntity> findFiles(String projectId); // 根据项目id查找文件

    @Select("select * from file where projectId = #{projectId} and modelId = #{modelId}")
    List<FileEntity> findFilesByQuestion(String projectId, String modelId);  // 根据项目id和问题id查找文件

    @Insert("insert into file values(0, #{fileName}, #{filePath}, #{fileSize}, #{fileType}, #{projectId}, #{modelId})")
    int addFile(FileEntity file); // 添加一个文件

    @Delete("delete from file where filePath = #{filePath}")
    int deleteFile(String filePath);  // 删除一个文件

    @Update("update file set modelId = #{modelId} where fileId = #{fileId}")
    int updateFile(String modelId, int fileId);    // 更新一个文件的问题/史诗id

}

//    may the force be with you.
//    @ClassName   FileMapper
//    Created by 24 on 2023/5/26.
