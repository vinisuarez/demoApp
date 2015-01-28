package com.vini.demo.taskmanager.repository.tasktype;

import com.vini.demo.taskmanager.model.TaskType;

import java.util.List;

public interface TaskTypeRepository {

    List<TaskType> findAll();

    TaskType findById(String id);

    void save(TaskType task);

    void delete(TaskType task);
}
