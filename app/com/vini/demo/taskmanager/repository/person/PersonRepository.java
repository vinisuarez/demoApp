package com.vini.demo.taskmanager.repository.person;

import com.vini.demo.taskmanager.model.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> findAll();

    Person findById(String id);

    void save(Person task);

    void delete(Person task);
}
