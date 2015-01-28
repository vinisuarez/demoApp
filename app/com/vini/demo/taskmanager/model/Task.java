package com.vini.demo.taskmanager.model;

import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import play.data.validation.*;

@Entity
public class Task extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    public String startDate;

    public String dueDate;

    public Long personId;

    @Constraints.Required
    public Long taskTypeId;

    @Constraints.Required
    public String description;

    public String getName() {
        return name;
    }

}
