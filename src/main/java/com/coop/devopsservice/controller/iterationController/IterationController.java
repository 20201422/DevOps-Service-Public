package com.coop.devopsservice.controller.iterationController;

import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.entity.iterationEntity.Iteration;
import com.coop.devopsservice.serviceImpl.IterationServiceImpl;
import com.coop.devopsservice.serviceImpl.QuestionServiceImpl;
import com.coop.devopsservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/iteration")
public class IterationController {
    private IterationServiceImpl iterationService;
    private QuestionServiceImpl questionService;
    public IterationController() {
    }
    @Autowired
    public IterationController(IterationServiceImpl iterationService,QuestionServiceImpl questionService) {
        this.iterationService = iterationService;
        this.questionService = questionService;
    }

    @GetMapping("/iterations")
    public ApiResult<?> findIterations() {    // 查找全部迭代
        System.out.println("查询全部迭代");
        return ApiResultHandler.success(iterationService.findIterations());
    }
    @GetMapping("/iterations/{projectId}")
    public ApiResult<?> findIterationsByProjectId(@PathVariable("projectId") String projectId){
        return ApiResultHandler.success(iterationService.findIterationsByProjectId(projectId));
    }
    @PostMapping("/add")
    public ApiResult<?> addIteration(@RequestBody Iteration iteration){   //添加迭代
        System.out.println("添加迭代");
        return ApiResultHandler.success(iterationService.addIteration(iteration));
    }
    @PostMapping("/update")
    public ApiResult<?> updateIteration(@RequestBody Iteration iteration){
        System.out.println("更新迭代");
        return ApiResultHandler.success(iterationService.updateIteration(iteration));
    }
    @GetMapping("/{iterationId}")
    public ApiResult<?> findQuestionById(@PathVariable("iterationId") int iterationId) {  // 根据id查找迭代
        System.out.println("根据ID查找迭代");
        return ApiResultHandler.success(iterationService.findIterationById(iterationId));
    }
    @GetMapping("/del/{iterationId}")
    public ApiResult<?> deleteById(@PathVariable("iterationId") int iterationId){
        System.out.println("删除迭代");
        return ApiResultHandler.success(iterationService.deleteIterationById(iterationId));
    }
    //将问题添加到迭代，即更新问题的iterationId
    @GetMapping("/addToIteration")
    public ApiResult<?> addQuestionToIterationById(@RequestParam("questionId") String questionId,@RequestParam("iterationId") int iterationId){;
        return ApiResultHandler.success(iterationService.addQuestionToIterationById(questionId, iterationId));
    }

    @GetMapping("/find/{iterationName}")   //为什么要加个find？因为不加会和findQuestionById冲突，前端会不知道选哪个方法
    public ApiResult<?> findIdByName(@PathVariable("iterationName") String iterationName){
        return ApiResultHandler.success(iterationService.findIdByName(iterationName));
    }
    @GetMapping("/getOpenedIteration/{projectId}")
    public ApiResult<?> findOpenedIteration(@PathVariable("projectId") String projectId){
        return ApiResultHandler.success(iterationService.findOpenedIteration(projectId));

    }
    @GetMapping("/findQuestionsByState/{iterationId}/{questionState}")
    public ApiResult<?> findQuestionsByState(@PathVariable("iterationId") int iterationId,@PathVariable("questionState") String state){    //根据状态查找一个或多个问题
        return ApiResultHandler.success(questionService.findQuestionByState(iterationId,state));
    }
    @GetMapping("/findQuestionByIterationId/{iterationId}")
    public ApiResult<?> findQuestionByIterationId(@PathVariable("iterationId") int iterationId){
        System.out.println("迭代id："+iterationId);
        return ApiResultHandler.success(questionService.findQuestionByIterationId(iterationId));
    }
    @GetMapping("/close/{iterationId}")
    public ApiResult<?> closeIteration(@PathVariable("iterationId") int iterationId){
        System.out.println("关闭迭代");
        return ApiResultHandler.success(iterationService.closeIteration(iterationId));
    }
    @GetMapping("/open/{iterationId}")
    public ApiResult<?> openIteration(@PathVariable("iterationId") int iterationId){
        return ApiResultHandler.success(iterationService.openIteration(iterationId));
    }
    @GetMapping("/getFreeQuestion/{projectId}")
    public ApiResult findQuestionFree(@PathVariable("projectId") String projectId){
        return ApiResultHandler.success(questionService.findQuestionFree(projectId));
    }

    public IterationServiceImpl getIterationService() {
        return iterationService;
    }

    public void setIterationService(IterationServiceImpl iterationService) {
        this.iterationService = iterationService;
    }

    public QuestionServiceImpl getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }
}
