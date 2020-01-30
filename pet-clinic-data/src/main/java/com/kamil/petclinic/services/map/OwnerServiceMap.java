package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap  extends  AbstractMapService<Owner,Long> implements CrudService<Owner,Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner change(Long id, Owner obj) {
        return super.change(id,obj);
    }

    @Override
    public Owner delete(Owner obj) {
        return super.delete(obj);
    }

    @Override
    public Owner deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Owner save(Owner obj) {
        return super.save(obj.getId(),obj);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
