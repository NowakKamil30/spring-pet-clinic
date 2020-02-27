package com.kamil.petclinic.controller;

import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public Set<Pet> getAllPet(){
        return petService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Pet getPetById(@PathVariable(value = "id") Long id){
        return petService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Pet postPet(@RequestBody Pet pet){
        return petService.save(pet);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Pet putPet(@PathVariable(value = "id")Long id,@RequestBody Pet pet){
        return petService.change(id,pet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable(value = "id")Long id){
         petService.deleteById(id);
    }
}
