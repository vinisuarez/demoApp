package com.vini.demo.taskmanager;

import com.google.common.collect.Lists;
import com.vini.demo.taskmanager.model.Task;
import com.vini.demo.taskmanager.repository.task.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TaskService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        LOG.debug("Listing all tasks");
        return Lists.newArrayList(taskRepository.findAll());
    }

    public Task findTaskById(String id) {
        Task person = taskRepository.findById(id);
        return person;
    }

    public void createNew(Task task) {
        LOG.debug("Task {} was saved", task.getName());
        taskRepository.save(task);
    }

    public void exclude(Task task) {
        LOG.debug("Task {} will be excluded", task.getName());
        taskRepository.delete(task);
    }
}
