package com.kamil.petclinic.services.map;

import com.kamil.petclinic.model.Speciality;
import com.kamil.petclinic.services.SpecialitesService;
import jdk.jshell.spi.SPIResolutionException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
@Profile(value = "map")
public class SpecialityServiceMap extends AbstractMapService<Speciality,Long> implements SpecialitesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality change(Long id, Speciality obj) {
        return super.change(id, obj);
    }

    @Override
    public Speciality delete(Speciality obj) {
        return super.delete(obj);
    }

    @Override
    public Speciality deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Speciality save(Speciality obj) {
        return super.save(obj);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
