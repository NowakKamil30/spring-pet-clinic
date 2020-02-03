package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.model.PetType;
import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.repositories.PetTypeRepository;
import com.kamil.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class PetTypeServiceJpa implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    @Autowired
    public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();

        petTypeRepository.findAll().forEach(petTypes::add);

        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType obj) {
        return petTypeRepository.save(obj);
    }

    @Override
    public void deleteById(Long aLong){
        petTypeRepository.deleteById(aLong);
    }

    @Override
    public void delete(PetType obj) {
        petTypeRepository.delete(obj);
    }

    @Override
    public PetType change(Long aLong, PetType obj) {
        Optional<PetType> optionalPetType = petTypeRepository.findById(aLong);
        if(optionalPetType.isPresent()){
            optionalPetType.get().setPetType(obj);
            return petTypeRepository.save(optionalPetType.get());
        }
        return null;
    }
}
