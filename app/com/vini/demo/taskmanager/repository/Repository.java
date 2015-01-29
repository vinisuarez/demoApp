package com.vini.demo.taskmanager.repository;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();

    T findById(String id);

    void save(T object);

    void delete(T object);
}
