package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.model.Speciality;
import com.kamil.petclinic.model.Visit;
import com.kamil.petclinic.repositories.VisitRepository;
import com.kamil.petclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile(value = "jpa")
public class VisitServiceJpa implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitServiceJpa(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        Optional<Visit> visitOptional = visitRepository.findById(aLong);
        if(visitOptional.isEmpty()){
            throw new NotFoundException("Visit Not Found id: " + aLong);
        }
        return visitOptional.orElse(null);
    }

    @Override
    public Visit save(Visit obj) {
        obj.getPet().getVisits().add(obj);
        return visitRepository.save(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }

    @Override
    public void delete(Visit obj) {
        visitRepository.delete(obj);
    }

    @Override
    public Visit change(Long aLong, Visit obj) {
        Optional<Visit> visitOptional = visitRepository.findById(aLong);
        if(visitOptional.isPresent()){
            visitOptional.get().setVisit(obj);
            visitOptional.get().setId(aLong);
            return save(visitOptional.get());
        }
        obj.setId(aLong);
        return save(obj);
    }
}

