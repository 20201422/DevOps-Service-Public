/**
 * @ClassName FileEntity
 * @Author 24
 * @Date 2023/5/26 22:18
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.entity.fileEntity;

public class FileEntity {

    private int fileId;
    private String fileName;
    private String filePath;
    private String fileSize;
    private String fileType;
    private String projectId;
    private String modelId;

    public FileEntity() {
    }

    public FileEntity(int fileId, String fileName, String filePath, String fileSize, String fileType,
                      String projectId, String modelId) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.projectId = projectId;
        this.modelId = modelId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        return "FileEmpty{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", projectId='" + projectId + '\'' +
                ", questionId='" + modelId + '\'' +
                '}';
    }
}

//    may the force be with you.
//    @ClassName   FileEntity
//    Created by 24 on 2023/5/26.
