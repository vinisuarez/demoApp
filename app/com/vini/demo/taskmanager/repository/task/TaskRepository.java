package com.vini.demo.taskmanager.repository.task;

import com.vini.demo.taskmanager.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAll();

    Task findById(String id);

    void save(Task task);

    void delete(Task task);
}
