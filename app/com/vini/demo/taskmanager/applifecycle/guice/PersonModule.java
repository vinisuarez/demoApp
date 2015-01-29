package com.vini.demo.taskmanager.applifecycle.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.vini.demo.taskmanager.PersonService;
import com.vini.demo.taskmanager.model.Person;
import com.vini.demo.taskmanager.repository.Repository;
import com.vini.demo.taskmanager.repository.memory.MemoryPersonRepository;

public class PersonModule extends AbstractModule{
    @Override
    protected void configure() {
        //Implemented as @Provides methods
    }

    @Provides
    @Singleton
    Repository<Person> personRepository() {
        return new MemoryPersonRepository();
    }

    @Provides @Singleton
    PersonService personService(Repository<Person> personRepository) {
        return new PersonService(personRepository);
    }
}
