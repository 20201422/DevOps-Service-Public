/**
 * @ClassName FileServiceImpl
 * @Author 24
 * @Date 2023/5/26 22:32
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.serviceImpl;

import com.coop.devopsservice.entity.fileEntity.FileEntity;
import com.coop.devopsservice.mapper.FileMapper;
import com.coop.devopsservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private FileMapper fileMapper;

    public FileServiceImpl() {
    }

    @Autowired
    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public FileMapper getFileMapper() {
        return fileMapper;
    }

    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public List<FileEntity> findFiles(String projectId) {
        return fileMapper.findFiles(projectId);
    }

    @Override
    public List<FileEntity> findFilesByQuestion(String projectId, String modelId) {
        return fileMapper.findFilesByQuestion(projectId, modelId);
    }

    @Override
    public int addFile(FileEntity file) {
        return fileMapper.addFile(file);
    }

    @Override
    public int deleteFile(String filePath) {
        return fileMapper.deleteFile(filePath);
    }

    @Override
    public int updateFile(String modelId, int fileId) { // 更新一个文件的问题/史诗id
        return fileMapper.updateFile(modelId, fileId);
    }
}

//    may the force be with you.
//    @ClassName   FileServiceImpl
//    Created by 24 on 2023/5/26.
