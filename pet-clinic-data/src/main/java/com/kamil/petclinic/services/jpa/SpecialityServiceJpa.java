package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.model.Speciality;
import com.kamil.petclinic.repositories.SpeciatlityRepository;
import com.kamil.petclinic.services.SpecialitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class SpecialityServiceJpa implements SpecialitesService {

    private final SpeciatlityRepository speciatlityRepository;

    @Autowired
    public SpecialityServiceJpa(SpeciatlityRepository speciatlityRepository) {
        this.speciatlityRepository = speciatlityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        speciatlityRepository.findAll().forEach(specialities::add);
        if(specialities.size() == 0){
            throw new NotFoundException("list is empty");
        }
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        Optional<Speciality> optionalSpeciality = speciatlityRepository.findById(aLong);
        if(optionalSpeciality.isEmpty()){
            throw new NotFoundException("Speciality Not Found id: " + aLong);
        }
        return optionalSpeciality.orElse(null);
    }

    @Override
    public Speciality save(Speciality obj) {
        return speciatlityRepository.save(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        speciatlityRepository.deleteById(aLong);
    }

    @Override
    public void delete(Speciality obj) {
        speciatlityRepository.delete(obj);
    }

    @Override
    public Speciality change(Long aLong, Speciality obj) {
        Optional<Speciality> specialityOptional = speciatlityRepository.findById(aLong);
        if(specialityOptional.isPresent()){
            specialityOptional.get().setSpeciality(obj);
            specialityOptional.get().setId(aLong);
            return save(specialityOptional.get());
        }
        obj.setId(aLong);
        return save(obj);
    }
}

