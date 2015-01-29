package com.vini.demo.taskmanager.repository.memory;

import com.vini.demo.taskmanager.model.Person;
import com.vini.demo.taskmanager.repository.Repository;
import play.db.ebean.Model;

import java.util.List;

public class MemoryPersonRepository implements Repository<Person> {

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> findAll() {
        return new Model.Finder(String.class, Person.class).all();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Person findById(String id) {
        return (Person) new Model.Finder(String.class, Person.class).byId(id);
    }

    @Override
    public void save(Person person) {
        person.save();
    }

    @Override
    public void delete(Person person) {
        person.delete();
    }
}
