package com.kamil.petclinic.services;

import com.kamil.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}
