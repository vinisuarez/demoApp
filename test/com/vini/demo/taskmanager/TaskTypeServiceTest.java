package com.vini.demo.taskmanager;

import com.vini.demo.taskmanager.model.TaskType;
import com.vini.demo.taskmanager.repository.Repository;
import com.vini.demo.taskmanager.repository.memory.MemoryTaskTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class TaskTypeServiceTest {

    TaskTypeService taskTypeService;
    Repository<TaskType> taskTypeRepositoryMock;

    @Before
    public void setup() {
        taskTypeRepositoryMock = Mockito.mock(MemoryTaskTypeRepository.class);
        taskTypeService = new TaskTypeService(taskTypeRepositoryMock);

        List<TaskType> taskTypeList = getTaskTypeForTest();
        when(taskTypeRepositoryMock.findAll()).thenReturn(taskTypeList);
        when(taskTypeRepositoryMock.findById(anyLong())).thenReturn(new TaskType(0L, "DummyTest"));
    }

    private List<TaskType> getTaskTypeForTest() {
        return Arrays.asList(new TaskType(1L, "Work"), new TaskType(2L, "House Work"),
                new TaskType(3L, "Grocery store"), new TaskType(4L, "Jog"));
    }

    @Test
    public void shouldGetAllTaskTypesSortedByName() {
        List<TaskType> sortedTaskTypes = taskTypeService.getAllTaskTypesSortedByName();

        assertEquals(sortedTaskTypes.get(0).getName(), "Grocery store");
        assertEquals(sortedTaskTypes.get(1).getName(), "House Work");
        assertEquals(sortedTaskTypes.get(2).getName(), "Jog");
        assertEquals(sortedTaskTypes.get(3).getName(), "Work");
    }

    @Test
    public void testFindTaskTypeById() {
        TaskType taskType = taskTypeService.findTaskTypeById(0L);
        assertEquals(new Long(0), taskType.getId());
        assertEquals("DummyTest", taskType.getName());
    }

    @Test
    public void testCreateNew() {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("name", "testTaskType");

        taskTypeService.createNew(requestMap);

        verify(taskTypeRepositoryMock, times(1)).save(any(TaskType.class));
    }

    @Test
    public void testExclude() {
        taskTypeService.exclude(0L);
        verify(taskTypeRepositoryMock, times(1)).delete(any(TaskType.class));
    }
}