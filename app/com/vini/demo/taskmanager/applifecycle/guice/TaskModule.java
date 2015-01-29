package com.vini.demo.taskmanager.applifecycle.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.vini.demo.taskmanager.TaskService;
import com.vini.demo.taskmanager.model.Task;
import com.vini.demo.taskmanager.repository.Repository;
import com.vini.demo.taskmanager.repository.memory.MemoryTaskRepository;

public class TaskModule extends AbstractModule {

    @Override
    protected void configure() {
        //Implemented as @Provides methods
    }

    @Provides @Singleton
    Repository<Task> taskRepository() {
        return new MemoryTaskRepository();
    }

    @Provides @Singleton
    TaskService taskService( Repository<Task> taskRepository) {
        return new TaskService(taskRepository);
    }
}
