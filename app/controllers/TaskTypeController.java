package controllers;

import com.google.inject.Inject;
import com.vini.demo.taskmanager.TaskTypeService;
import com.vini.demo.taskmanager.model.TaskType;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.taskType;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TaskTypeController extends Controller {
    private final TaskTypeService taskTypeService;

    @Inject
    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    public Result index(){
        List<TaskType> allTaskTypes = taskTypeService.findAllTaskTypes();
        Collections.sort(allTaskTypes, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        return ok(taskType.render(allTaskTypes));
    }

    public Result addTaskType() {
        Map requestData = Form.form().bindFromRequest().get().getData();
        taskTypeService.createNew(requestData);
        return index();
    }

    public Result remove(Long id){
        taskTypeService.exclude(id);
        return index();
    }
}
