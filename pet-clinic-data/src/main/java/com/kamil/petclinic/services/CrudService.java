package com.kamil.petclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T obj);
    T deleteById(ID id);
    T delete(T obj);
    T change(ID id, T obj);
}
