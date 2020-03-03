package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Owner;
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
        if(petTypes.size() == 0){
            throw new NotFoundException("list is empty");
        }
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        Optional<PetType> petTypeOptional = petTypeRepository.findById(aLong);
        if(!petTypeOptional.isPresent()){
            throw new NotFoundException("PetType Not Found id: " + aLong);
        }
        return petTypeOptional.orElse(null);
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
            optionalPetType.get().setId(aLong);
            return save(optionalPetType.get());
        }
        obj.setId(aLong);
        return save(obj);
    }
}
