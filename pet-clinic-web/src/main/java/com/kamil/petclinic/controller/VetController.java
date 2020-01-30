package com.kamil.petclinic.controller;

import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/vet")
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService =  vetService;
    }

    @GetMapping("")
    public Set<Vet> getAllOwners()
    {
        return vetService.findAll();
    }

    @GetMapping("/{id}")
    public Vet getById(@PathVariable(value = "id") Long id)
    {
        return vetService.findById(id);
    }

    @PostMapping("")
    public Vet postOwner(@RequestBody Vet vet)
    {
        return vetService.save(vet);
    }

    @PutMapping("/{id}")
    public Vet putOwner(@PathVariable(value="id") Long id, @RequestBody Vet vet)
    {
        return vetService.change(id, vet);
    }

    @DeleteMapping("/{id}")
    public Vet deleteById(@PathVariable(value="id") Long id)
    {
        return vetService.deleteById(id);
    }
}
