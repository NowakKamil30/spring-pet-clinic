package com.kamil.petclinic.services.map;


import com.kamil.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Long ownerId;
    String ownerLastName;

    @BeforeEach
    void setUp() {
        ownerId = 1L;
        ownerLastName = "Nowak";
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(ownerLastName);
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void change() {
        String lastName = "aaa";
        Owner owner = ownerServiceMap.findById(ownerId);
        owner.setLastName(lastName);
        Owner changedOwner = ownerServiceMap.change(ownerId,owner);
        assertEquals(lastName,changedOwner.getLastName());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveWhenIdExist() {
        final Long id =2L;
        Owner owner = new Owner();
        owner.setId(id);
        Owner savedOwner = ownerServiceMap.save(owner);
        assertEquals(id,savedOwner.getId());
    }
    @Test
    void saveWhenIdDoentExist(){
        Owner owner = new Owner();
        Owner savedOwner = ownerServiceMap.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }
    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(ownerLastName);

        assertNotNull(owner);
        assertEquals(ownerLastName,owner.getLastName());
    }
    @Test
    void findByLastNameWithWhiteWhiteSpace() {
        Owner owner = ownerServiceMap.findByLastName(ownerLastName+" ");

        assertNotNull(owner);
        assertEquals(ownerLastName,owner.getLastName());
    }
    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName(ownerLastName+"sad");

        assertEquals(null,owner);
    }
}