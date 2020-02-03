package com.kamil.petclinic.repositories;

import com.kamil.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Optional<Owner> findByLastName(String lastName);
}
