package com.kamil.petclinic.controller;

import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(value = HttpStatus.OK)
    public Set<Vet> getAllVet()
    {
        return vetService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Vet getById(@PathVariable(value = "id") Long id)
    {
        return vetService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vet postOwner(@RequestBody Vet vet)
    {
        return vetService.save(vet);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Vet putOwner(@PathVariable(value="id") Long id, @RequestBody Vet vet) {
        return vetService.change(id, vet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable(value="id") Long id)
    {
         vetService.deleteById(id);
    }
}
