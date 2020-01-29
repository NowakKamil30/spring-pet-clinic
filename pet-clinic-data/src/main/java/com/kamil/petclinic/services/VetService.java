package com.kamil.petclinic.services;


import com.kamil.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet owner);
    Vet delete(Long id);
    Vet change(Long id, Vet owner);
    Set<Vet> findAll();
}
