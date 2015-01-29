package com.vini.demo.taskmanager;

import com.google.common.collect.Lists;
import com.vini.demo.taskmanager.model.Person;
import com.vini.demo.taskmanager.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonService {
    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    private final Repository<Person> personRepository;

    public PersonService(Repository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAllPersons() {
        LOG.debug("Listing all persons");
        return Lists.newArrayList(personRepository.findAll());
    }

    public Person findPersonById(String id) {
        Person person = personRepository.findById(id);
        return person;
    }

    public void createNew(Person person) {
        LOG.debug("Person {} was saved", person.getName());
        personRepository.save(person);
    }

    public void exclude(Person person) {
        LOG.debug("Person {} will be excluded", person.getName());
        personRepository.delete(person);
    }
}
