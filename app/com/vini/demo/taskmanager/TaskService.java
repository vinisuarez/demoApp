package com.vini.demo.taskmanager;

import com.google.common.collect.Lists;
import com.vini.demo.taskmanager.model.Task;
import com.vini.demo.taskmanager.repository.Repository;
import com.vini.demo.taskmanager.util.TaskRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class TaskService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskService.class);

    private final Repository<Task> taskRepository;

    public TaskService(Repository<Task> taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        LOG.debug("Listing all tasks");
        return Lists.newArrayList(taskRepository.findAll());
    }

    public Task findTaskById(String id) {
        Task task = taskRepository.findById(id);
        return task;
    }

    public void createNew(Map requestData) {
        Task task = TaskRequestUtil.adaptRequestToTask(requestData);
        LOG.debug("Task {} was saved", task.getName());
        taskRepository.save(task);
    }

    public void markAsDone(Map requestData) {
        String taskId = TaskRequestUtil.adaptMarkAsDone(requestData);
        Task task = findTaskById(taskId);
        task.setDone(!task.isDone());

        LOG.debug("Task {} was marked as done = {}", task.getName(), task.isDone());
        taskRepository.save(task);
    }

    public void exclude(Task task) {
        LOG.debug("Task {} will be excluded", task.getName());
        taskRepository.delete(task);
    }
}
