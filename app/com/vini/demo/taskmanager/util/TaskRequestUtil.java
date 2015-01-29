package com.vini.demo.taskmanager.util;

import com.vini.demo.taskmanager.PersonService;
import com.vini.demo.taskmanager.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class TaskRequestUtil {
    private static final Logger LOG = LoggerFactory.getLogger(TaskRequestUtil.class);

    public static Task adaptRequestToTask(Map requestData) {
        return new Task.Builder()
                .setName(getValue(requestData, "name"))
                .setStartDate(getValue(requestData, "startDate"))
                .setDueDate(getValue(requestData, "dueDate"))
                .setPersonId(getValue(requestData, "personId"))
                .setTaskTypeId(getValue(requestData, "taskTypeId"))
                .setDescription(getDescription(requestData))
                .Build();
    }

    public static String adaptMarkAsDone(Map requestData) {
        return getValue(requestData, "id");
    }

    private static String getValue(Map requestData, String key) {
        return String.valueOf(requestData.get(key));
    }

    private static String getDescription(Map requestData) {
        String description = "";
        try {
            description = URLEncoder.encode(getValue(requestData, "description"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("Unsupported text added to description");
        }
        return description;
    }
}
