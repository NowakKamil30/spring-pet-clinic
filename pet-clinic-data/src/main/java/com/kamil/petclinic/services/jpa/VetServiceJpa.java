package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.model.Speciality;
import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.repositories.VetRepository;
import com.kamil.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class VetServiceJpa implements VetService {

    private final VetRepository vetRepository;

    @Autowired
    public VetServiceJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);

        if(vets.size() == 0){
            throw new NotFoundException("list is empty");
        }
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> optionalVet = vetRepository.findById(aLong);
        if(optionalVet.isEmpty()){
            throw new NotFoundException("Vet Not Found id: " + aLong);
        }
        return optionalVet.orElse(null);
    }

    @Override
    public Vet save(Vet obj) {
        return vetRepository.save(obj);
    }

    @Override
    public void deleteById(Long aLong) {
            vetRepository.deleteById(aLong);
    }

    @Override
    public void delete(Vet obj) {
            vetRepository.delete(obj);
    }

    @Override
    public Vet change(Long aLong, Vet obj) {
        Optional<Vet> optionalVet = vetRepository.findById(aLong);
        if(optionalVet.isPresent()){
            optionalVet.get().setVet(obj);
            optionalVet.get().setId(aLong);
            return save(optionalVet.get());
        }
        obj.setId(aLong);
        return save(obj);
    }
}
