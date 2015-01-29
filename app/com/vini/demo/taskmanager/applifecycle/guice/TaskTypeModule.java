package com.vini.demo.taskmanager.applifecycle.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.vini.demo.taskmanager.TaskTypeService;
import com.vini.demo.taskmanager.model.TaskType;
import com.vini.demo.taskmanager.repository.Repository;
import com.vini.demo.taskmanager.repository.memory.MemoryTaskTypeRepository;

public class TaskTypeModule extends AbstractModule {
    @Override
    protected void configure() {
        //Implemented as @Provides methods
    }

    @Provides
    @Singleton
    Repository<TaskType> taskTypeRepository() {
        return new MemoryTaskTypeRepository();
    }

    @Provides @Singleton
    TaskTypeService taskTypeService(Repository<TaskType> taskTypeRepository) {
        return new TaskTypeService(taskTypeRepository);
    }
}
