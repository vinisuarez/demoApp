package com.vini.demo.taskmanager.applifecycle.guice;

import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new TaskModule());
        install(new TaskTypeModule());
    }
}
