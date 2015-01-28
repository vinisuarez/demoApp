package com.vini.demo.taskmanager.applifecycle.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.vini.demo.taskmanager.TaskTypeService;
import com.vini.demo.taskmanager.repository.tasktype.MemoryTaskTypeRepository;
import com.vini.demo.taskmanager.repository.tasktype.TaskTypeRepository;

public class TaskTypeModule extends AbstractModule {
    @Override
    protected void configure() {
        //Implemented as @Provides methods
    }

    @Provides
    @Singleton
    TaskTypeRepository taskTypeRepository() {
        return new MemoryTaskTypeRepository();
    }

    @Provides @Singleton
    TaskTypeService taskTypeService(TaskTypeRepository taskTypeRepository) {
        return new TaskTypeService(taskTypeRepository);
    }
}
