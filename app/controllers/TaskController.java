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

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TaskController extends Controller {

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
        List<TaskType> allTaskTypes = taskTypeService.findAllTaskTypes();
        Collections.sort(allTaskTypes,(a,b) -> a.getName().compareToIgnoreCase(b.getName()));
        return ok(newTaskPage.render(allTaskTypes));
    }

    public Result add() {
        Map requestData = Form.form().bindFromRequest().get().getData();
        taskService.createNew(requestData);
        return listPage();
    }

    public Result listPage() {
        List<Task> allTasks = taskService.findAllTasks();
        return ok(listTaskPage.render(allTasks));
    }

    public Result remove(Long id) {
        taskService.exclude(id);
        return listPage();
    }

    public Result toggleDone() {
        Map requestData = Form.form().bindFromRequest().get().getData();
        taskService.toggleDone(requestData);
        return listPage();
    }

}
