package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.repositories.OwnerRepository;
import com.kamil.petclinic.repositories.PetRepository;
import com.kamil.petclinic.repositories.PetTypeRepository;
import com.kamil.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class OwnerServiceJpa implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceJpa(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        Optional<Owner> optionalOwner = ownerRepository.findByLastName(lastName);
        if(!optionalOwner.isPresent()){
            throw new NotFoundException("Owner Not Found. For last name " + lastName);
        }
        return optionalOwner.orElse(null);
    }

    @Override
    public List<Owner> findAllByLastName(String lastName) {
        List<Owner> ownerList = ownerRepository.findAllByLastName(lastName);
        if(ownerList.size() == 0)
        {
            throw new NotFoundException("list is empty");
        }
        return ownerList;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        if(owners.size() == 0){
            throw new NotFoundException("list is empty");
        }
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner= ownerRepository.findById(aLong);
        if(!optionalOwner.isPresent()){
            throw new NotFoundException("Owner Not Found id: " + aLong);
        }
        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner obj) {
        for(Pet pet: obj.getPets()){
            pet.setOwner(obj);
        }
        return ownerRepository.save(obj);
    }

    @Override
    public void deleteById(Long aLong) {
            ownerRepository.deleteById(aLong);
    }

    @Override
    public void delete(Owner obj) {
            ownerRepository.delete(obj);
    }

    @Override
    public Owner change(Long aLong, Owner obj) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        if(optionalOwner.isPresent()){
            optionalOwner.get().setOwner(obj);
            optionalOwner.get().setId(aLong);
            return save(optionalOwner.get());
        }
        obj.setId(aLong);
        return save(obj);
    }
}
