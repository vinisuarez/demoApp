package com.vini.demo.taskmanager;

import com.google.common.collect.Lists;
import com.vini.demo.taskmanager.model.TaskType;
import com.vini.demo.taskmanager.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TaskTypeService {
    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    private final Repository<TaskType> taskTypeRepository;

    public TaskTypeService(Repository<TaskType> taskTypeRepository) {
        this.taskTypeRepository = taskTypeRepository;
    }

    public List<TaskType> findAllTaskTypes() {
        LOG.debug("Listing all tasks types");
        return Lists.newArrayList(taskTypeRepository.findAll());
    }

    public TaskType findTaksTypeById(String id) {
        TaskType person = taskTypeRepository.findById(id);
        return person;
    }

    public void createNew(TaskType taskType) {
        LOG.debug("Task type {} was saved", taskType.getName());
        taskTypeRepository.save(taskType);
    }

    public void exclude(TaskType taskType) {
        LOG.debug("Task type {} will be excluded", taskType.getName());
        taskTypeRepository.delete(taskType);
    }
}
