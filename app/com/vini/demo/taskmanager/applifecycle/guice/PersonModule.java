package com.vini.demo.taskmanager.applifecycle.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.vini.demo.taskmanager.PersonService;
import com.vini.demo.taskmanager.model.Person;
import com.vini.demo.taskmanager.repository.person.MemoryPersonRepository;
import com.vini.demo.taskmanager.repository.person.PersonRepository;

public class PersonModule extends AbstractModule{
    @Override
    protected void configure() {
        //Implemented as @Provides methods
    }

    @Provides
    @Singleton
    PersonRepository personRepository() {
        return new MemoryPersonRepository();
    }

    @Provides @Singleton
    PersonService personService(PersonRepository personRepository) {
        return new PersonService(personRepository);
    }
}
