package com.vini.demo.taskmanager.repository.tasktype;

import com.vini.demo.taskmanager.model.TaskType;
import play.db.ebean.Model;

import java.util.List;

public class MemoryTaskTypeRepository implements TaskTypeRepository {

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
    public void save(TaskType task) {
        task.save();
    }

    @Override
    public void delete(TaskType task) {
        task.delete();
    }
}
