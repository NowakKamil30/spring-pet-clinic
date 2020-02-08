package com.kamil.petclinic.controller;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("")
    public Set<Owner> getAllOwners()
    {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public Owner getById(@PathVariable(value = "id") Long id)
    {
        return ownerService.findById(id);
    }

    @PostMapping("")
    public Owner postOwner(@RequestBody Owner owner)
    {
        return ownerService.save(owner);
    }

    @PutMapping("/{id}")
    public Owner putOwner(@PathVariable(value="id") Long id, @RequestBody Owner owner)
    {
       return ownerService.change(id, owner);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value="id") Long id)
    {
         ownerService.deleteById(id);
    }

}
