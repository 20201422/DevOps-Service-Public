/**
 * @ClassName FileService
 * @Author 24
 * @Date 2023/5/26 22:31
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.service;

import com.coop.devopsservice.entity.fileEntity.FileEntity;

import java.util.List;

public interface FileService {

    List<FileEntity> findFiles(String projectId);
    List<FileEntity> findFilesByQuestion(String projectId, String modelId);
    int addFile(FileEntity file);
    int deleteFile(String filePath);
    int updateFile(String modelId, int fileId);

}

//    may the force be with you.
//    @ClassName   FileService
//    Created by 24 on 2023/5/26.
