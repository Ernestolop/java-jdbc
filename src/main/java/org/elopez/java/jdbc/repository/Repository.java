package org.elopez.java.jdbc.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}
