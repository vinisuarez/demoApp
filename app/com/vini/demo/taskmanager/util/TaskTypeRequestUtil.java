package com.vini.demo.taskmanager.util;

import com.vini.demo.taskmanager.model.Task;
import com.vini.demo.taskmanager.model.TaskType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static org.apache.commons.beanutils.BeanUtils.populate;

public class TaskTypeRequestUtil {

    private static final Logger LOG = LoggerFactory.getLogger(TaskTypeRequestUtil.class);

    @SuppressWarnings("unchecked")
    public static TaskType adaptRequestToTask(Map requestData) {
        TaskType taskType = new TaskType();
        try {
            populate(taskType, requestData);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOG.error("Unable to map request to Task type bean", e);
        }
        return taskType;
    }
}
