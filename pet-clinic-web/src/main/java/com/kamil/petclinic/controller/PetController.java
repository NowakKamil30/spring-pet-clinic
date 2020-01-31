package com.kamil.petclinic.controller;

import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("")
    public Set<Pet> getAllPet(){
        return petService.findAll();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable(value = "id") Long id){
        return petService.findById(id);
    }

    @PostMapping("")
    public Pet postPet(@RequestBody Pet pet){
        return petService.save(pet);
    }

    @PutMapping("/{id}")
    public Pet putPet(@PathVariable(value = "id")Long id,@RequestBody Pet pet){
        return petService.change(id,pet);
    }

    @DeleteMapping("/{id}")
    public Pet deletePetById(@PathVariable(value = "id")Long id){
        return petService.deleteById(id);
    }
}
