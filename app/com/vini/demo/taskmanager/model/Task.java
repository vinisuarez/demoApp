package com.vini.demo.taskmanager.model;

import play.db.ebean.Model;

import javax.persistence.*;
import play.data.validation.*;

@Entity
public class Task extends Model {

    public Task(String name, String startDate, String dueDate, String personId,
                String taskTypeId, String description) {
        this.name = name;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.personId = personId;
        this.taskTypeId = taskTypeId;
        this.description = description;
    }

    @Id
    private Long id;
    private String name;
    private String startDate;
    private String dueDate;
    private String personId;
    private String taskTypeId;
    private String description;
    private boolean isDone;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPersonId() {
        return personId;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean isDone () {
        return isDone;
    }

    public static final class Builder {

        public Builder() {
        }

        private String name;
        private String startDate;
        private String dueDate;
        private String personId;
        private String taskTypeId;
        private String description;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setDueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder setPersonId(String personId) {
            this.personId = personId;
            return this;
        }

        public Builder setTaskTypeId(String taskTypeId) {
            this.taskTypeId = taskTypeId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Task Build() {
            return new Task(name, startDate, dueDate, personId, taskTypeId, description);
        }
    }

}
