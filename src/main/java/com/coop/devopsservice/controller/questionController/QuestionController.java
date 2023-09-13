/**
 * @ClassName QuestionController
 * @Author 24
 * @Date 2023/5/18 21:08
 * @Version 1.0.0
 * freedom is the oxygen of the soul.
 **/

package com.coop.devopsservice.controller.questionController;

import com.coop.devopsservice.controller.FileController.FileController;
import com.coop.devopsservice.designPattern.kp_facadePattern.AbstractModelSequenceFacade;
import com.coop.devopsservice.designPattern.kp_facadePattern.QuestionSequenceFacade;
import com.coop.devopsservice.designPattern.kp_factoryPattern.FastModel;
import com.coop.devopsservice.designPattern.kp_factoryPattern.FastModelFactory;
import com.coop.devopsservice.designPattern.kp_factoryPattern.FastQuestionFactory;
import com.coop.devopsservice.designPattern.kp_flyweightPattern.QuestionFactory;
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
import java.util.Objects;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionServiceImpl questionService;
    private EpicServiceImpl epicService;
    private FileServiceImpl fileService;
    private AbstractModelSequenceFacade questionSequenceFacade = new QuestionSequenceFacade();

    public QuestionController() {
    }

    @Autowired
    public QuestionController(QuestionServiceImpl questionService, EpicServiceImpl epicService,
                              FileServiceImpl fileService, AbstractModelSequenceFacade questionSequenceFacade) {
        this.questionService = questionService;
        this.epicService = epicService;
        this.fileService = fileService;
        this.questionSequenceFacade = questionSequenceFacade;
    }
    public QuestionServiceImpl getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    public EpicServiceImpl getEpicService() {
        return epicService;
    }

    public void setEpicService(EpicServiceImpl epicService) {
        this.epicService = epicService;
    }

    public FileServiceImpl getFileService() {
        return fileService;
    }

    public void setFileService(FileServiceImpl fileService) {
        this.fileService = fileService;
    }

    public AbstractModelSequenceFacade getQuestionSequenceFacade() {
        return questionSequenceFacade;
    }

    public void setQuestionSequenceFacade(AbstractModelSequenceFacade questionSequenceFacade) {
        this.questionSequenceFacade = questionSequenceFacade;
    }

    @GetMapping("/questions/{projectId}")
    public ApiResult<?> findQuestions(@PathVariable("projectId") String projectId) {    // 查找全部问题
        System.out.println("查询全部问题");
        return ApiResultHandler.success(questionService.findQuestions(projectId));
    }

    @GetMapping("/{questionId}/{projectId}")
    public ApiResult<?> findQuestionById(@PathVariable("questionId") String questionId, @PathVariable("projectId") String projectId) {  // 根据id查找问题
        System.out.println("根据ID查找问题");
        return ApiResultHandler.success(questionService.findQuestionById(questionId, projectId));
    }

    public ApiResult findQuestionByStateAndPriority(String projectId,String questionState,String questionPriority){
        return ApiResultHandler.success(questionService.findQuestionByStateAndPriority(projectId,questionState,questionPriority));
    }

    @PostMapping("/add")
    public ApiResult<?> addQuestion(@RequestBody Question question) {    // 添加一个问题
        System.out.println("添加问题");

        QuestionFactory questionFactory = QuestionFactory.getInstance();    // 获取享元工厂对象
        question.setQuestionState(Objects.requireNonNull(questionFactory.getQuestionState("规划中")).getQuestionState());
        questionService.addQuestion(question);

        updateEpicState(question.getEpicId(), question.getProjectId());  // 修改史诗状态

        return ApiResultHandler.success();
    }

    @GetMapping("/fastAdd")
    public ApiResult<?> addFastQuestion(@RequestParam("questionId") String questionId, @RequestParam("questionName")String questionName,
                                        @RequestParam("questionPriority")String questionPriority,@RequestParam("userId") String userId,
                                        @RequestParam("iterationId")int iterationId,@RequestParam("projectId")String projectId) {   // 快速添加一个问题
        FastModelFactory fastQuestionFactory =
                new FastQuestionFactory(questionId, questionName, questionPriority, userId,iterationId , projectId);
        FastModel fastQuestion = fastQuestionFactory.createFastModel();
        Question question = (Question) fastQuestion.addFastModel();
        return ApiResultHandler.success(questionService.addQuestion(question));
    }

    @DeleteMapping("/delete/{questionId}/{projectId}")
    public ApiResult<?> deleteQuestionById(@PathVariable("questionId") String questionId,
                                           @PathVariable("projectId") String projectId) {    // 删除一个问题
        System.out.println("删除问题");

        List<FileEntity> files = fileService.findFilesByQuestion(projectId, questionId); // 找到问题的所有文件

        for (FileEntity file : files) { // 删除该问题下的文件
            fileService.deleteFile(file.getFilePath());
            new FileController().delete(file.getFilePath(), file.getProjectId());
        }

        Question question = questionService.findQuestionById(questionId, projectId);   // 找到问题
        questionService.deleteQuestionById(questionId, projectId); // 删除问题

        updateEpicState(question.getEpicId(), projectId);  // 修改史诗状态

        return ApiResultHandler.success();
    }

    @PutMapping("/update")
    public ApiResult<?> updateQuestion(@RequestBody Question question) {    // 更新问题
        System.out.println("更新问题");

        String oldQuestionId =
                questionService.findQuestionByIndex(question.getQuestionIndex()).getQuestionId();

        List<FileEntity> files = fileService.
                findFilesByQuestion(question.getProjectId(), oldQuestionId); // 找到问题的所有文件

        for (FileEntity file: files) {  // 更新文件的问题id
            file.setModelId(question.getQuestionId());
            fileService.updateFile(file.getModelId(), file.getFileId());
        }

        return ApiResultHandler.success(questionService.updateQuestion(question));
    }

    @GetMapping("/update/state")
    public ApiResult<?> updateQuestionState(@RequestParam("questionId") String questionId,
                                            @RequestParam("state")String state,
                                            @RequestParam("projectId") String projectId) { // 更新问题的状态
        System.out.println("更新问题的状态");
        Question question = questionService.findQuestionById(questionId, projectId);   // 找到问题
        if (!Objects.equals(question.getQuestionState(), state)) {
            QuestionFactory questionFactory = QuestionFactory.getInstance();    // 获取享元工厂对象
            question.setQuestionState(questionFactory.getQuestionState(state).getQuestionState());
            questionService.updateQuestion(question);
            
            updateEpicState(question.getEpicId(), projectId);  // 修改史诗状态
            
            return ApiResultHandler.success();
        }
        
        return null;
    }

    private void updateEpicState(String epicId, String projectId) {
        Epic epic = epicService.findEpicById(epicId, projectId); // 找到问题对应的史诗

        if (epic != null) { // 如果存在史诗

            String epicState = epic.getEpicState(); // 获取史诗状态
            epic = new EpicState(questionService) {
                @Override
                public String setQuestionState() {
                    return null;
                }
            }.stateCheck(epic); // 检查史诗状态

            if (!Objects.equals(epic.getEpicState(), epicState)) {  // 如果状态发生改变了
                epicService.updateEpic(epic);   // 改变史诗状态
            }
        }
    }

    @PostMapping("/update/sequence")
    public ApiResult<?> updateQuestionSequence(@RequestBody Question question) {   // 更改问题的顺序
        System.out.println("更新问题的顺序");

        questionSequenceFacade.changeSequence(question);

        return ApiResultHandler.success();
    }

}

//    may the force be with you.
//    @ClassName   QuestionController
//    Created by 24 on 2023/5/18.
