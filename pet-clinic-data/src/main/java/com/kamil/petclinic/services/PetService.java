package com.kamil.petclinic.services;


import com.kamil.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Pet delete(Long id);
    Pet change(Long id, Pet owner);
    Set<Pet> findAll();
}
