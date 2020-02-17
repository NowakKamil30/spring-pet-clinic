package com.kamil.petclinic.bootstrap;


import com.kamil.petclinic.model.*;
import com.kamil.petclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialitesService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetService petService,
                      PetTypeService petTypeService,
                      SpecialitesService specialityService,
                      VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size() == 0){
            initialData();
        }
    }

    private void initialData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedCatPetType = petTypeService.save(cat);
        PetType savedDogPetType =petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("sth");
        specialityService.save(radiology);


        Owner owner1 = new Owner();
        owner1.setFirstName("first");
        owner1.setLastName("last");
        owner1.setAddress("134 321");
        owner1.setCity("city");
        owner1.setTelephone("111111111");

        Pet mika = new Pet();
        mika.setName("Mika");
        mika.setPetType(savedCatPetType);
        mika.setOwner(owner1);
        mika.setBirthDate(LocalDate.now());
        owner1.getPets().add(mika);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("first1");
        owner2.setLastName("last1");
        owner2.setAddress("134 222");
        owner2.setCity("city2");
        owner2.setTelephone("211111112");

        Pet doge = new Pet();
        doge.setName("DOGE");
        doge.setPetType(savedDogPetType);
        doge.setOwner(owner2);
        doge.setBirthDate(LocalDate.now());
        owner2.getPets().add(doge);
        ownerService.save(owner2);

        Visit visit = new Visit();
        visit.setPet(doge);
        visit.setDate(LocalDate.now());
        visit.setDescription("lalalala");

        visitService.save(visit);


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("vet1");
        vet1.setLastName("vet1 last");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("vet2");
        vet2.setLastName("vet2 last");
        vet2.getSpecialities().add(radiology);

        vetService.save(vet2);

    }
}
