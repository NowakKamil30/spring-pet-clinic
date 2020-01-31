package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.Speciality;
import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.services.SpecialitesService;
import com.kamil.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = "map")
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialitesService specialitesService;

    @Autowired
    public VetServiceMap(SpecialitesService specialitesService) {
        this.specialitesService = specialitesService;
    }

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

        if(obj.getSpecialities().size() > 0){
            obj.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialitesService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
