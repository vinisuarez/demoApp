package com.vini.demo.taskmanager;

import com.google.common.collect.Lists;
import com.vini.demo.taskmanager.model.TaskType;
import com.vini.demo.taskmanager.repository.Repository;
import com.vini.demo.taskmanager.util.TaskTypeRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class TaskTypeService {
    private static final Logger LOG = LoggerFactory.getLogger(TaskTypeService.class);

    private final Repository<TaskType> taskTypeRepository;

    public TaskTypeService(Repository<TaskType> taskTypeRepository) {
        this.taskTypeRepository = taskTypeRepository;
    }

    public List<TaskType> findAllTaskTypes() {
        LOG.debug("Listing all tasks types");
        return Lists.newArrayList(taskTypeRepository.findAll());
    }

    public TaskType findTaskTypeById(Long id) {
        TaskType taskType = taskTypeRepository.findById(id);
        return taskType;
    }

    public void createNew(Map requestData) {
        TaskType taskType = TaskTypeRequestUtil.adaptRequestToTask(requestData);
        LOG.debug("Task type {} was saved", taskType.getName());
        taskTypeRepository.save(taskType);
    }

    public void exclude(Long taskTypeId) {
        TaskType taskType = findTaskTypeById(taskTypeId);
        LOG.debug("Task type {} will be excluded", taskType.getName());
        taskTypeRepository.delete(taskType);
    }
}
