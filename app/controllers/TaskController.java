package controllers;

import com.google.inject.Inject;
import com.vini.demo.taskmanager.TaskService;
import com.vini.demo.taskmanager.TaskTypeService;
import com.vini.demo.taskmanager.model.Task;
import com.vini.demo.taskmanager.model.TaskType;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.listTaskPage;
import views.html.newTaskPage;

import java.util.List;
import java.util.Map;

public class TaskController extends Controller {

    private static final String TASK_LIST_URL = "/task/list";
    private final TaskService taskService;
    private final TaskTypeService taskTypeService;

    @Inject
    TaskController(TaskService taskService,
                   TaskTypeService taskTypeService) {
        this.taskService = taskService;
        this.taskTypeService = taskTypeService;
    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result newTaskPage() {
        List<TaskType> taskTypes = taskTypeService.getAllTaskTypesSortedByName();
        return ok(newTaskPage.render(taskTypes));
    }

    public Result add() {
        Map requestData = Form.form().bindFromRequest().get().getData();
        taskService.createNew(requestData);
        return redirect(TASK_LIST_URL);
    }

    public Result listPage() {
        List<Task> allTasks = taskService.findAllTasks();
        List<TaskType> taskTypes = taskTypeService.getAllTaskTypesSortedByName();
        return ok(listTaskPage.render(allTasks, taskTypes));
    }

    public Result remove(Long id) {
        taskService.exclude(id);
        return redirect(TASK_LIST_URL);
    }

    public Result toggleDone() {
        Map requestData = Form.form().bindFromRequest().get().getData();
        taskService.toggleDone(requestData);
        return ok();
    }

}
