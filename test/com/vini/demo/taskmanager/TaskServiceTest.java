package com.vini.demo.taskmanager;

import com.vini.demo.taskmanager.model.Task;
import com.vini.demo.taskmanager.repository.Repository;
import com.vini.demo.taskmanager.repository.memory.MemoryTaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class TaskServiceTest {
    
    TaskService taskService;
    Repository<Task> taskRepositoryMock;
    
    @Before
    public void setup() {
        taskRepositoryMock = mock(MemoryTaskRepository.class);
        taskService = new TaskService(taskRepositoryMock);

        when(taskRepositoryMock.findAll()).thenReturn(getTaskForTest());
        when(taskRepositoryMock.findById(anyLong())).thenReturn(getTaskForTest().get(0));
    }

    private List<Task> getTaskForTest() {
        return Arrays.asList(
                new Task(0L, "Make some task", "28 January, 2015", "31 January, 2015", "1", "Make some task in one day", true),
                new Task(1L, "Study math", "1 February, 2015", "28 February, 2015", "2", "Study logarithm", false));
    }

    @Test
    public void shouldFindAllTasks() {
        assertEquals(2, taskService.findAllTasks().size());
    }

    @Test
    public void shouldFindTaskById() {
        assertEquals(new Long(0), taskService.findTaskById(0L).getId());
    }

    @Test
    public void shouldeCreateNew() {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name", "testTask");

        taskService.createNew(requestMap);

        verify(taskRepositoryMock, times(1)).save(any(Task.class));
    }

    @Test
    public void shouldToggleTaskDone() {
        ArgumentCaptor<Task> argument = ArgumentCaptor.forClass(Task.class);

        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("id", "0" );

        taskService.toggleDone(requestMap);

        verify(taskRepositoryMock, times(1)).save(argument.capture());
        assertFalse(argument.getValue().isDone());
    }

    @Test
    public void shouldExcludeTask() {
        taskService.exclude(0L);
        verify(taskRepositoryMock, times(1)).delete(any(Task.class));
    }
}