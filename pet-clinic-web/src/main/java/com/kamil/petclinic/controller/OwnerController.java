package com.kamil.petclinic.controller;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.services.OwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(description = "Owners have pets")
@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @ApiOperation(value = "this will get a list of owners")
    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public Set<Owner> getAllOwners()
    {
        return ownerService.findAll();
    }

    @ApiOperation(value = "this will get a single owner")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Owner getById(@PathVariable(value = "id") Long id)
    {
        return ownerService.findById(id);
    }


    @ApiOperation(value = "this will create a owner")
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Owner postOwner(@RequestBody Owner owner)
    {
        return ownerService.save(owner);
    }

    @ApiOperation(value = "this will modify a owner")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Owner putOwner(@PathVariable(value="id") Long id, @RequestBody Owner owner)
    {
       return ownerService.change(id, owner);
    }

    @ApiOperation(value = "this will delete a owner")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable(value="id") Long id)
    {
         ownerService.deleteById(id);
    }

}
