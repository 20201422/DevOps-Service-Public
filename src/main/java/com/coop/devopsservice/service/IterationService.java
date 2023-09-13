package com.coop.devopsservice.service;

import com.coop.devopsservice.entity.iterationEntity.Iteration;

import java.util.List;

public interface IterationService {
    List<Iteration> findIterations();

    List<Iteration> findIterationsByProjectId(String projectId);

    Iteration findIterationById(int IterationId);

    int addIteration(Iteration iteration);

    int deleteIterationById(int IterationId);

    int updateIteration(Iteration iteration);

    int addQuestionToIterationById(String questionId, int iterationId);

    int findIdByName(String iterationName);

    Iteration findOpenedIteration(String projectId);

    int closeIteration(int iterationId);

    int openIteration(int iterationId);

}
