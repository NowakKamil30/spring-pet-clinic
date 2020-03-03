package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.model.Visit;
import com.kamil.petclinic.repositories.PetRepository;
import com.kamil.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile(value= "jpa")
public class PetServiceJpa implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceJpa(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        if(pets.size() == 0){
            throw new NotFoundException("list is empty");
        }
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        Optional<Pet> optionalPet = petRepository.findById(aLong);
        if(!optionalPet.isPresent()){
            throw new NotFoundException("Pet Not Found id: " + aLong);
        }
        return optionalPet.orElse(null);
    }

    @Override
    public Pet save(Pet obj) {
        for(Visit visit: obj.getVisits()){
            visit.setPet(obj);
        }
        return petRepository.save(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }

    @Override
    public void delete(Pet obj) {
        petRepository.delete(obj);
    }

    @Override
    public Pet change(Long aLong, Pet obj) {
        Optional<Pet> optionalPet = petRepository.findById(aLong);
        if(optionalPet.isPresent()){
            optionalPet.get().setPet(obj);
            optionalPet.get().setId(aLong);
            return petRepository.save(optionalPet.get());
        }
        obj.setId(aLong);
        return save(obj);
    }
}
