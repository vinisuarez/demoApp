package com.vini.demo.taskmanager.util;

import com.vini.demo.taskmanager.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static org.apache.commons.beanutils.BeanUtils.populate;

public class TaskRequestUtil {
    private static final Logger LOG = LoggerFactory.getLogger(TaskRequestUtil.class);

    @SuppressWarnings("unchecked")
    public static Task adaptRequestToTask(Map requestData) {
        Task task = new Task();
        try {
            populate(task, requestData);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOG.error("Unable to map request to Task bean", e);
        }
        return task;
    }

    public static String getTaskIdFromRequest(Map requestData) {
        return String.valueOf(requestData.get("id"));
    }
}
