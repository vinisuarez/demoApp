package com.vini.demo.taskmanager.model;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person extends Model{

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    public String getName() {
        return name;
    }
}
