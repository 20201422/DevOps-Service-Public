package com.coop.devopsservice.controller.FileController;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    private String port;
    private static final String ip ="http://localhost";

    public FileController() {
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @PostMapping("/upload/{projectId}")
    @CrossOrigin
    public ApiResult<?> upload(MultipartFile file, @PathVariable("projectId") String projectId) throws IOException {
        System.out.println("上传文件");
        String originalFilename =  file.getOriginalFilename();
        String path = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir") +
                "/files/" + projectId + "/" + path + "_" + originalFilename;
        FileUtil.writeBytes(file.getBytes(), rootFilePath);

        return ApiResultHandler.success(path);
    }

    @GetMapping("/{path}/{projectId}")
    public void getFile(@PathVariable String path,@PathVariable("projectId") String projectId, HttpServletResponse response) {
        System.out.println("下载文件");
        OutputStream os;
        String basePath = System.getProperty("user.dir")+ "/files/"+ projectId + "/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String fileName = fileNames.stream().filter(name->name.contains(path)).findAny().orElse("");
        try{
            if(StrUtil.isNotEmpty(fileName)){
                response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath+fileName);
                os=response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            System.out.println("文件下载失败");
        }
    }

    @GetMapping("/delete/{path}/{projectId}")
    public ApiResult<?> delete(@PathVariable String path, @PathVariable("projectId") String projectId) {
        System.out.println("删除文件");
        String basePath = System.getProperty("user.dir")+ "/files/" + projectId + "/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String fileName = fileNames.stream().filter(name->name.contains(path)).findAny().orElse("");

        if(StrUtil.isNotEmpty(fileName)){
            File file = new File(basePath + fileName);
            boolean success = FileUtil.del(file);
            if (success) {
                return ApiResultHandler.success("Success");
            } else {
                return ApiResultHandler.success("Failed to delete the file");
            }
        }
        return ApiResultHandler.success("File not found");
    }
}
