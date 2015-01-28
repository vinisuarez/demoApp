package com.vini.demo.taskmanager.applifecycle.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.vini.demo.taskmanager.TaskService;
import com.vini.demo.taskmanager.repository.task.MemoryTaskRepository;
import com.vini.demo.taskmanager.repository.task.TaskRepository;

public class TaskModule extends AbstractModule {

    @Override
    protected void configure() {
        //Implemented as @Provides methods
    }

    @Provides @Singleton
    TaskRepository taskRepository() {
        return new MemoryTaskRepository();
    }

    @Provides @Singleton
    TaskService taskService(TaskRepository taskRepository) {
        return new TaskService(taskRepository);
    }
}
