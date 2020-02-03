package com.kamil.petclinic.services.jpa;

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
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit obj) {
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
            return visitRepository.save(visitOptional.get());
        }
        return null;
    }
}

