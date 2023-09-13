/**
 * @ClassName ProjectController
 * @Author 24
 * @Date 2023/5/18 21:18
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.controller.projectController;


import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.entity.projectEntity.Project;
import com.coop.devopsservice.serviceImpl.ProjectServiceImpl;
import com.coop.devopsservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("project")
public class ProjectController {

    private ProjectServiceImpl projectService;

    public ProjectController() {
    }

    @Autowired
    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    public ProjectServiceImpl getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects/{userId}")
    public ApiResult<?> findProjects(@PathVariable("userId") String userId) {    // 查找全部项目
        System.out.println("查询全部项目");
        return ApiResultHandler.success(projectService.findProjects(userId));
    }

    @GetMapping("/{projectId}")
    public ApiResult<?> findProjectById(@PathVariable("projectId") String projectId) {  // 根据id查找项目
        System.out.println("根据ID查找项目");
        return ApiResultHandler.success(projectService.findProjectById(projectId));
    }

    @PostMapping("/add")
    public ApiResult<?> addProject(Project project) {    // 添加一个项目
        System.out.println("添加项目");
        return ApiResultHandler.success(projectService.addProject(project));
    }

    @DeleteMapping("/delete/{questionId}")
    public ApiResult<?> deleteProjectById(@PathVariable("questionId") String projectId) {    // 删除一个项目
        System.out.println("删除项目");
        return ApiResultHandler.success(projectService.deleteProjectById(projectId));
    }

    @PutMapping("/update")
    public ApiResult<?> updateProject(Project project) {    // 更新项目
        System.out.println("更新项目");
        return ApiResultHandler.success(projectService.updateProject(project));
    }
}

//    may the force be with you.
//    @ClassName   ProjectController
//    Created by 24 on 2023/5/18.
