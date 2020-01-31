package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = "map")
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet change(Long id, Vet obj) {
        return super.change(id,obj);
    }

    @Override
    public Vet delete(Vet obj) {
        return super.delete(obj);
    }

    @Override
    public Vet deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Vet save(Vet obj) {
        return super.save(obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
