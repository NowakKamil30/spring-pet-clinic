package com.kamil.petclinic.controller;

import com.kamil.petclinic.model.Visit;
import com.kamil.petclinic.services.VisitService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/visit")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping()
    public Set<Visit> getAllVisit(){
        return visitService.findAll();
    }

    @GetMapping("/{id}")
    public Visit getVisit(@PathVariable(name = "id") Long id){
        return visitService.findById(id);
    }

    @PostMapping()
    public Visit postVisit(@RequestBody Visit visit){
        return visitService.save(visit);
    }
    @PutMapping("/{id}")
    public Visit putVisit(@PathVariable(name = "id") Long id,@RequestBody Visit visit){
        return visitService.change(id,visit);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name="id") Long id){
        visitService.deleteById(id);
    }
}
