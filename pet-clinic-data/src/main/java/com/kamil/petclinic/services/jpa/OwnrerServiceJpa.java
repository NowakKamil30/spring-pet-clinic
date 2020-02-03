package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.repositories.OwnerRepository;
import com.kamil.petclinic.repositories.PetRepository;
import com.kamil.petclinic.repositories.PetTypeRepository;
import com.kamil.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class OwnrerServiceJpa implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    @Autowired
    public OwnrerServiceJpa(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        Optional<Owner> optionalOwner = ownerRepository.findByLastName(lastName);

        return optionalOwner.orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner= ownerRepository.findById(aLong);

        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner obj) {
        return ownerRepository.save(obj);
    }

    @Override
    public Owner deleteById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        if(optionalOwner.isPresent()){
            ownerRepository.deleteById(aLong);
            return optionalOwner.get();
        }
        return null;
    }

    @Override
    public Owner delete(Owner obj) {
        Optional<Owner> optionalOwner = ownerRepository.findById(obj.getId());
        if(optionalOwner.isPresent()){
            ownerRepository.delete(obj);
            return optionalOwner.get();
        }
        return null;

    }

    @Override
    public Owner change(Long aLong, Owner obj) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        if(optionalOwner.isPresent()){
            optionalOwner.get().setOwner(obj);
            return ownerRepository.save(optionalOwner.get());
        }
        return null;
    }
}
