package com.kamil.petclinic.services;

import com.kamil.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Owner delete(Long id);
    Owner change(Long id, Owner owner);
    Set<Owner> findAll();
}
