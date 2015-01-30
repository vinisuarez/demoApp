package com.vini.demo.taskmanager.model;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskType extends Model {

    @Id
    private Long id;

    @Constraints.Required
    private String name;

    public TaskType() {
    }

    public TaskType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
