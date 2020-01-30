package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet,Long> implements CrudService<Vet,Long> {
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
        return super.save(obj.getId(),obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
