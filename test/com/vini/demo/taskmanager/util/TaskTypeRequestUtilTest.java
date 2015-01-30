package com.vini.demo.taskmanager.util;

import com.vini.demo.taskmanager.model.TaskType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TaskTypeRequestUtilTest {

    @Test
    public void shouldAdaptRequestToTask() throws Exception {
        String name = "Work";

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name", name);

        TaskType taskType = TaskTypeRequestUtil.adaptRequestToTask(requestMap);
        assertEquals(name, taskType.getName());
    }
}