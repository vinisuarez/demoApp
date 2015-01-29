package com.vini.demo.taskmanager.repository.memory;

import com.vini.demo.taskmanager.model.TaskType;
import com.vini.demo.taskmanager.repository.Repository;
import play.db.ebean.Model;

import java.util.List;

public class MemoryTaskTypeRepository implements Repository<TaskType> {

    @SuppressWarnings("unchecked")
    @Override
    public List<TaskType> findAll() {
        return new Model.Finder(String.class, TaskType.class).all();
    }

    @SuppressWarnings("unchecked")
    @Override
    public TaskType findById(String id) {
        return (TaskType) new Model.Finder(String.class, TaskType.class).byId(id);
    }

    @Override
    public void save(TaskType taskType) {
        taskType.save();
    }

    @Override
    public void delete(TaskType taskType) {
        taskType.delete();
    }

    @Override
    public void update(TaskType taskType) {
        taskType.update(taskType.getId());
    }
}
