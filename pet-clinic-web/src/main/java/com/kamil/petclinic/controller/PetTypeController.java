package com.kamil.petclinic.controller;


import com.kamil.petclinic.model.Pet;
import com.kamil.petclinic.model.PetType;
import com.kamil.petclinic.services.PetTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(description = "PetType")
@RestController
@RequestMapping("/pet_type")
public class PetTypeController {

    private final PetTypeService petTypeService;

    public PetTypeController(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @ApiOperation(value = "this will get a list of petTypes")
    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public Set<PetType> getAllPetType(){
        return petTypeService.findAll();
    }

    @ApiOperation(value = "this will get a single petType")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PetType getPetById(@PathVariable(value = "id") Long id){
        return petTypeService.findById(id);
    }

    @ApiOperation(value = "this will create a pet")
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PetType postPet(@RequestBody PetType petType){
        return petTypeService.save(petType);
    }

    @ApiOperation(value = "this will modify a pet")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PetType putPet(@PathVariable(value = "id")Long id,@RequestBody PetType petType){
        return petTypeService.change(id,petType);
    }
}
