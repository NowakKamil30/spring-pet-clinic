package com.kamil.petclinic.services.jpa;

import com.kamil.petclinic.exceptions.NotFoundException;
import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.repositories.OwnerRepository;
import com.kamil.petclinic.repositories.PetRepository;
import com.kamil.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceJpa ownerServiceJpa;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        String ownerLastName = "Nowak";
        Optional<Owner> owner = Optional.ofNullable(new Owner());
        owner.get().setId(1L);
        owner.get().setLastName(ownerLastName);
        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner onwerFound = ownerServiceJpa.findByLastName(ownerLastName);

        assertEquals(owner.get().getLastName(),onwerFound.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAllByLastName(){
        String ownerLastName = "Nowak";
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName(ownerLastName);
        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setLastName(ownerLastName);

        List<Owner> owners = new ArrayList<>();

        owners.add(owner);
        owners.add(owner1);

        when(ownerRepository.findAllByLastName(any())).thenReturn(owners);

        List<Owner> ownersTest = ownerServiceJpa.findAllByLastName(ownerLastName);

        assertEquals(owners.size(),ownersTest.size());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(1L);
        Owner owner1 = new Owner();
        owner1.setId(2L);
        owners.add(owner);
        owners.add(owner1);

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> ownersTest = ownerServiceJpa.findAll();

        assertNotNull(ownersTest);
        assertEquals(owners.size(),ownersTest.size());
    }
    @Test
    void findAllIsEmpty() {
        Set<Owner> owners = new HashSet<>();

        when(ownerRepository.findAll()).thenReturn(owners);

        assertThrows(NotFoundException.class,()->{
            Set<Owner> ownersTest = ownerServiceJpa.findAll();
        });

    }

    @Test
    void findById() {
        Optional<Owner> owner = Optional.of(new Owner());
        owner.get().setId(1L);

        when(ownerRepository.findById(1L)).thenReturn(owner);

        Owner ownerTest = ownerServiceJpa.findById(1L);
        assertEquals(ownerTest.getId(),owner.get().getId());
    }
    @Test()
    void findByIdNotFound(){

        when(ownerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class,()->ownerServiceJpa.findById(1L));

    }
    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner ownerTest = ownerServiceJpa.save(ownerToSave);

        assertNotNull(ownerTest);
    }

    @Test
    void deleteById() {
        Owner owner = new Owner();
        owner.setId(1L);

        ownerServiceJpa.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());


    }

    @Test
    void delete() {
        Owner owner = new Owner();
        owner.setId(1L);

        ownerServiceJpa.delete(owner);

        verify(ownerRepository).delete(any());

    }

    @Test
    void change() {

    }
}