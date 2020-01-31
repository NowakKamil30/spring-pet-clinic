package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.PetType;
import com.kamil.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = "map")
public class PetTypeServiceMap extends  AbstractMapService<PetType,Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType change(Long id, PetType obj) {
        return super.change(id,obj);
    }

    @Override
    public PetType delete(PetType obj) {
        return super.delete(obj);
    }

    @Override
    public PetType deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public PetType save(PetType obj) {
        return super.save(obj);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
