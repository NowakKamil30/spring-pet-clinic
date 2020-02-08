package com.kamil.petclinic.services;

import com.kamil.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastName(String lastName);
}
