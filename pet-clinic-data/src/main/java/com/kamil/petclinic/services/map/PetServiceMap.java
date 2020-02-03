package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


import java.util.Set;

@Service
@Profile(value = "map")
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet change(Long id, Pet obj) {
        return super.change(id,obj);
    }

    @Override
    public void delete(Pet obj) {
         super.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
         super.deleteById(id);
    }

    @Override
    public Pet save(Pet obj) {
        return super.save(obj);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
