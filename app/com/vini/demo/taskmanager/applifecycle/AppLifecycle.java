package com.vini.demo.taskmanager.applifecycle;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vini.demo.taskmanager.applifecycle.guice.MainModule;
import com.vini.demo.taskmanager.util.RequestConverter;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLifecycle {

    private static final Logger LOG = LoggerFactory.getLogger(AppLifecycle.class);

    private static Injector injector;

    public void onStart() {
        setupInjections();
        ConvertUtils.register(new RequestConverter(), String.class);
    }

    private void setupInjections() {
        LOG.info("Creating main guice injector");
        injector = Guice.createInjector(new MainModule());
    }

    public static Injector injector() {
        return injector;
    }
}
