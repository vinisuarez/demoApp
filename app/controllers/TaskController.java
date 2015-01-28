package controllers;

import com.google.inject.Inject;
import com.vini.demo.taskmanager.PersonService;
import com.vini.demo.taskmanager.TaskService;
import com.vini.demo.taskmanager.TaskTypeService;
import com.vini.demo.taskmanager.model.Task;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

import java.util.List;

public class TaskController extends Controller {

    private final TaskService taskService;
    private final TaskTypeService taskTypeService;
    private final PersonService personService;

    @Inject
    TaskController(TaskService taskService,
                   TaskTypeService taskTypeService,
                   PersonService personService) {
        this.taskService = taskService;
        this.taskTypeService = taskTypeService;
        this.personService = personService;
    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result newTaskPage() {
        return ok(newTaskPage.render());
    }

    public Result addTask() {
        Task task = Form.form(Task.class).bindFromRequest().get();
        taskService.createNew(task);
        return listTaskPage();
    }

    public Result listTaskPage() {
        List<Task> allTasks = taskService.findAllTasks();
        return ok(listTaskPage.render(allTasks));
    }

}
