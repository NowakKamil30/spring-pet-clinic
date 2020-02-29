package com.kamil.petclinic.controller;

import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.services.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(description = "pets have a visits")
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @ApiOperation(value = "this will get a list of pets")
    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public Set<Pet> getAllPet(){
        return petService.findAll();
    }

    @ApiOperation(value = "this will get a single pet")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Pet getPetById(@PathVariable(value = "id") Long id){
        return petService.findById(id);
    }

    @ApiOperation(value = "this will create a pet")
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Pet postPet(@RequestBody Pet pet){
        return petService.save(pet);
    }

    @ApiOperation(value = "this will modify a pet")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Pet putPet(@PathVariable(value = "id")Long id,@RequestBody Pet pet){
        return petService.change(id,pet);
    }

    @ApiOperation(value = "this will delete a pet")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable(value = "id")Long id){
         petService.deleteById(id);
    }
}
