package com.kamil.petclinic.bootstrap;


import com.kamil.petclinic.model.Owner;
import com.kamil.petclinic.model.PetType;
import com.kamil.petclinic.model.Vet;
import com.kamil.petclinic.services.OwnerService;
import com.kamil.petclinic.services.PetService;
import com.kamil.petclinic.services.PetTypeService;
import com.kamil.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedCatPetType = petTypeService.save(cat);
        PetType savedDogPetType =petTypeService.save(dog);



        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("first");
        owner1.setLastName("last");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("first1");
        owner2.setLastName("last1");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("vet1");
        vet1.setLastName("vet1 last");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("vet2");
        vet1.setLastName("vet2 last");

        vetService.save(vet2);

    }
}
