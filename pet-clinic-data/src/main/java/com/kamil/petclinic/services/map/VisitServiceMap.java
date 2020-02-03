package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.Visit;
import com.kamil.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = "map")
public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit change(Long id, Visit obj) {
        return super.change(id, obj);
    }

    @Override
    public void delete(Visit obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit obj) {
        if(obj.getPet() == null || obj.getPet().getOwner() == null || obj.getPet().getId() == null){
            throw new RuntimeException("invalid visit");
        }
        return super.save(obj);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
