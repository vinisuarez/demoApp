package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

public class Task extends Controller {

    public static Result newTask() {
        return ok(newTask.render());
    }

    public static Result listTask() {
        return ok(listTask.render());
    }

}
