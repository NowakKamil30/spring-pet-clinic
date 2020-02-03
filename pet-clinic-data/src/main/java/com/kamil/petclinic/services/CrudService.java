package com.kamil.petclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T obj);
    void deleteById(ID id);
    void delete(T obj);
    T change(ID id, T obj);
}
