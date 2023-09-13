/**
 * @ClassName FileDatabaseController
 * @Author 24
 * @Date 2023/5/27 10:54
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.controller.FileController;


import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.entity.fileEntity.FileEntity;
import com.coop.devopsservice.serviceImpl.FileServiceImpl;
import com.coop.devopsservice.util.ApiResultHandler;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/databaseFiles")
public class FileDatabaseController {

    private FileServiceImpl fileService;

    @Autowired
    public FileDatabaseController(FileServiceImpl fileService) {
        this.fileService = fileService;
    }

    public FileServiceImpl getFileService() {
        return fileService;
    }

    public void setFileService(FileServiceImpl fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/getFile/{projectId}/{modelId}")
    public ApiResult<?> findFiles(@PathVariable("projectId") String projectId,
                                  @PathVariable("modelId") String modelId) {
        System.out.println("找到问题下的文件");

        return ApiResultHandler.success(fileService.findFilesByQuestion(projectId, modelId));
    }

    @PostMapping("/addFile")
    public ApiResult<?> addFile(@RequestBody FileEntity file) {
        System.out.println("添加文件数据到数据库");

        return ApiResultHandler.success(fileService.addFile(file));
    }

    @DeleteMapping("/deleteFile/{filePath}")
    public ApiResult<?> delete(@PathVariable String filePath) {
        System.out.println("删除文件");

        return ApiResultHandler.success(fileService.deleteFile(filePath));
    }

    @PutMapping("/updateFile/{modelId}/{fileId}")
    public ApiResult<?> update(@PathVariable String modelId, @PathVariable int fileId) {
        System.out.println("更新文件的问题/史诗id");

        return ApiResultHandler.success(fileService.updateFile(modelId, fileId));
    }
}

//    may the force be with you.
//    @ClassName   FileDatabaseController
//    Created by 24 on 2023/5/27.
