package com.coop.devopsservice.serviceImpl;

import com.coop.devopsservice.designPattern.lrx_ProxyPattern.ProxyOpenIteration;
import com.coop.devopsservice.designPattern.lrx_commandPattern.AddQuestionCommand;
import com.coop.devopsservice.designPattern.lrx_commandPattern.Command;
import com.coop.devopsservice.designPattern.lrx_observerPattern.ConcreteIterationState;
import com.coop.devopsservice.designPattern.lrx_observerPattern.IterationState;
import com.coop.devopsservice.entity.iterationEntity.Iteration;
import com.coop.devopsservice.mapper.IterationMapper;
import com.coop.devopsservice.service.IterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IterationServiceImpl implements IterationService {
    private IterationMapper iterationMapper;
    @Autowired
    public IterationServiceImpl(IterationMapper iterationMapper) {
        this.iterationMapper = iterationMapper;
    }

    public IterationServiceImpl() {
    }

    @Override
    public List<Iteration> findIterations() {
        return iterationMapper.findIterations();
    }

    @Override
    public List<Iteration> findIterationsByProjectId(String projectId) {
        return iterationMapper.findIterationsByProjectId(projectId);
    }

    @Override
    public Iteration findIterationById(int iterationId) {
        return iterationMapper.findIterationById(iterationId);
    }

    @Override
    public int addIteration(Iteration iteration) {
       return iterationMapper.addIteration(iteration);
    }

    @Override
    public int deleteIterationById(int iterationId) {
        return iterationMapper.deleteIterationById(iterationId);
    }

    @Override
    public int updateIteration(Iteration iteration) {
        return iterationMapper.updateIteration(iteration);
    }

    @Override
    public int addQuestionToIterationById(String questionId, int iterationId) {
        Command addQuestionCmd = new AddQuestionCommand(questionId,iterationId,iterationMapper);  //获取添加问题命令
        return addQuestionCmd.execute();   //执行命令
    }

    @Override
    public int findIdByName(String iterationName) {
        return iterationMapper.findIdByName(iterationName);
    }

    @Override
    public Iteration findOpenedIteration(String projectId) {
        return iterationMapper.findOpenedIteration(projectId);
    }

    @Override
    public int closeIteration(int iterationId) {
        IterationState iterationState = new ConcreteIterationState(iterationId,iterationMapper);
        return iterationState.closeIterationState();   //关闭迭代
        //return iterationMapper.closeIteration(iterationId);
    }

    @Override
    public int openIteration(int iterationId) {
        IterationState iterationState = new ConcreteIterationState(iterationId,iterationMapper);
        //根据迭代id获取项目id，用来判断项目中开启的迭代数量
        String projectId = iterationMapper.getProjectIdByIterationId(iterationId);
        //定义代理开启对象
        ProxyOpenIteration proxyOpenIteration = new ProxyOpenIteration(iterationState,iterationMapper,projectId);
        return proxyOpenIteration.open();

        //return iterationState.openIterationState();
        //return iterationMapper.openIteration(iterationId);
    }


    public IterationMapper getIterationMapper() {
        return iterationMapper;
    }

    public void setIterationMapper(IterationMapper iterationMapper) {
        this.iterationMapper = iterationMapper;
    }

}
