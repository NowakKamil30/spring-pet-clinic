package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.services.CrudService;


import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet change(Long id, Pet obj) {
        return super.change(id,obj);
    }

    @Override
    public Pet delete(Pet obj) {
        return super.delete(obj);
    }

    @Override
    public Pet deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Pet save(Pet obj) {
        return super.save(obj.getId(),obj);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
