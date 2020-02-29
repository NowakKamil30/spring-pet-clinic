package com.kamil.petclinic.controller;

import com.kamil.petclinic.model.Visit;
import com.kamil.petclinic.services.VisitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@Api(description = "pet clinic visit")
@RestController
@RequestMapping("/visit")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @ApiOperation(value = "this will get a list of visits")
    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public Set<Visit> getAllVisit(){
        return visitService.findAll();
    }

    @ApiOperation(value = "this will get a single visit")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Visit getVisit(@PathVariable(name = "id") Long id){
        return visitService.findById(id);
    }
    @ApiOperation(value = "this will create a visit")
    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public Visit postVisit(@RequestBody Visit visit){
        return visitService.save(visit);
    }

    @ApiOperation(value = "this will modify a visit")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Visit putVisit(@PathVariable(name = "id") Long id,@RequestBody Visit visit){
        return visitService.change(id,visit);
    }

    @ApiOperation(value = "this will delete a visit")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable(name="id") Long id){
        visitService.deleteById(id);
    }
}
