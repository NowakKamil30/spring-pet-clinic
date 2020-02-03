package com.kamil.petclinic.repositories;

import com.kamil.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
