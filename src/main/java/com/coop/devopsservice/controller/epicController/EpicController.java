/**
 * @ClassName EpicController
 * @Author 24
 * @Date 2023/5/18 21:18
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.controller.epicController;

import com.coop.devopsservice.controller.FileController.FileController;
import com.coop.devopsservice.designPattern.kp_facadePattern.AbstractModelSequenceFacade;
import com.coop.devopsservice.designPattern.kp_facadePattern.EpicSequenceFacade;
import com.coop.devopsservice.designPattern.kp_statePattern.EpicState;
import com.coop.devopsservice.entity.ApiResult;
import com.coop.devopsservice.entity.epicEntity.Epic;
import com.coop.devopsservice.entity.fileEntity.FileEntity;
import com.coop.devopsservice.entity.questionEntity.Question;
import com.coop.devopsservice.serviceImpl.EpicServiceImpl;
import com.coop.devopsservice.serviceImpl.FileServiceImpl;
import com.coop.devopsservice.serviceImpl.QuestionServiceImpl;
import com.coop.devopsservice.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("epic")
public class EpicController {

    private EpicServiceImpl epicService;
    private QuestionServiceImpl questionService;
    private FileServiceImpl fileService;
    private AbstractModelSequenceFacade epicSequenceFacade = new EpicSequenceFacade();

    public EpicController() {
    }

    @Autowired
    public EpicController(EpicServiceImpl epicService, QuestionServiceImpl questionService,
                          FileServiceImpl fileService, AbstractModelSequenceFacade epicSequenceFacade) {
        this.epicService = epicService;
        this.questionService = questionService;
        this.fileService = fileService;
        this.epicSequenceFacade = epicSequenceFacade;
    }

    public EpicServiceImpl getEpicService() {
        return epicService;
    }

    public void setEpicService(EpicServiceImpl epicService) {
        this.epicService = epicService;
    }

    public QuestionServiceImpl getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    public FileServiceImpl getFileService() {
        return fileService;
    }

    public void setFileService(FileServiceImpl fileService) {
        this.fileService = fileService;
    }

    public AbstractModelSequenceFacade getEpicSequenceFacade() {
        return epicSequenceFacade;
    }

    public void setEpicSequenceFacade(AbstractModelSequenceFacade epicSequenceFacade) {
        this.epicSequenceFacade = epicSequenceFacade;
    }

    @GetMapping("/epics/{projectId}")
    public ApiResult<?> findEpics(@PathVariable("projectId") String projectId) {    // 查找全部史诗
        System.out.println("查询全部史诗");
        return ApiResultHandler.success(epicService.findEpics(projectId));
    }

    @GetMapping("/epics/idAndName/{projectId}")
    public ApiResult<?> findEpicsOnlyIdAndName(@PathVariable("projectId") String projectId) { // 查找史诗的id和名字
        System.out.println("查询史诗的id和名字");
        return ApiResultHandler.success(epicService.findEpicsOnlyIdAndName(projectId));
    }

    @GetMapping("/{questionId}/{projectId}")
    public ApiResult<?> findEpicById(@PathVariable("questionId") String epicId, @PathVariable("projectId") String projectId) {  // 根据id查找史诗
        System.out.println("根据ID查找史诗");
        return ApiResultHandler.success(epicService.findEpicById(epicId, projectId));
    }

    @PostMapping("/add")
    public ApiResult<?> addEpic(@RequestBody Epic epic) {    // 添加一个史诗
        System.out.println("添加史诗");
        epic = new EpicState(questionService) {
            @Override
            public String setQuestionState() {
                return null;
            }
        }.stateCheck(epic); // 检查史诗状态

        return ApiResultHandler.success(epicService.addEpic(epic));
    }

    @DeleteMapping("/delete/{epicId}/{projectId}")
    public ApiResult<?> deleteEpicById(@PathVariable("epicId") String epicId, @PathVariable("projectId") String projectId) {    // 删除一个史诗
        System.out.println("删除史诗");

        List<FileEntity> files = fileService.findFilesByQuestion(projectId, epicId); // 找到史诗的所有文件

        for (FileEntity file : files) { // 删除该史诗下的文件
            fileService.deleteFile(file.getFilePath());
            new FileController().delete(file.getFilePath(), file.getProjectId());
        }

        // 将该史诗下的问题的史诗id去掉
        List<Question> questions = questionService.findQuestionsByEpicId(epicId, projectId);

        for (Question question : questions) {
            question.setEpicId(null);
//            System.out.println(question);
            questionService.updateQuestion(question);
        }

        return ApiResultHandler.success(epicService.deleteEpicById(epicId, projectId));
    }

    @PutMapping("/update")
    public ApiResult<?> updateEpic(@RequestBody Epic epic) {    // 更新史诗
        System.out.println("更新史诗");

        String oldEpicId =
                epicService.findEpicByIndex(epic.getEpicIndex()).getEpicId();

        List<FileEntity> files = fileService.
                findFilesByQuestion(epic.getProjectId(), oldEpicId); // 找到史诗的所有文件
        for (FileEntity file: files) {  // 更新文件的史诗id
            file.setModelId(epic.getEpicId());
            fileService.updateFile(file.getModelId(), file.getFileId());
        }

        List<Question> questions = questionService
                .findQuestionsByEpicId(oldEpicId, epic.getProjectId());   // 找到所有史诗的问题
        for (Question question: questions) {
            question.setEpicId(epic.getEpicId());
            questionService.updateQuestion(question);
        }

        return ApiResultHandler.success(epicService.updateEpic(epic));
    }

    @PostMapping("/update/sequence")
    public ApiResult<?> updateEpicSequence(@RequestBody Epic epic) {   // 更改史诗的顺序
        System.out.println("更新史诗的顺序");

        epicSequenceFacade.changeSequence(epic);

        return ApiResultHandler.success();
    }

}

//    may the force be with you.
//    @ClassName   EpicController
//    Created by 24 on 2023/5/18.
