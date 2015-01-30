package com.vini.demo.taskmanager.util;

import com.vini.demo.taskmanager.model.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TaskRequestUtilTest {

    @Test
    public void shouldAdaptMapToTask() {
        String name = "Create a demo project";
        String startDate = "28, january,2015";
        String dueDate = "30, january,2015";
        String taskTypeId = "1";
        String description = "Make some cool demo project to show awesome Siili's engineers ;)";

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name", name);
        requestMap.put("startDate", startDate);
        requestMap.put("dueDate", dueDate);
        requestMap.put("taskTypeId", taskTypeId);
        requestMap.put("description", description);

        Task task = TaskRequestUtil.adaptRequestToTask(requestMap);

        assertEquals(name, task.getName());
        assertEquals(startDate, task.getStartDate());
        assertEquals(dueDate, task.getDueDate());
        assertEquals(taskTypeId, task.getTaskTypeId());
        assertEquals(description, task.getDescription());
    }

    @Test
    public void shouldGetCorrectIdFromRequest() {
        Map<String, String> requestMap = new HashMap<>();
        String id = "46";
        requestMap.put("id", id);

        assertEquals(id, TaskRequestUtil.getTaskIdFromRequest(requestMap));
    }
}