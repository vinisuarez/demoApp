package com.vini.demo.taskmanager.repository.memory;

import com.vini.demo.taskmanager.model.Task;
import com.vini.demo.taskmanager.repository.Repository;
import play.db.ebean.Model;

import java.util.List;

public class MemoryTaskRepository implements Repository<Task> {

    @SuppressWarnings("unchecked")
    @Override
    public List<Task> findAll() {
        return new Model.Finder(String.class, Task.class).all();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Task findById(Long id) {
        return (Task) new Model.Finder(String.class, Task.class).byId(id);
    }

    @Override
    public void save(Task task) {
        task.save();
    }

    @Override
    public void delete(Task task) {
        task.delete();
    }
}
