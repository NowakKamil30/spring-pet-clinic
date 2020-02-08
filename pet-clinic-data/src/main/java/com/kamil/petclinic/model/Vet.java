package com.kamil.petclinic.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch =  FetchType.EAGER)
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    @NotNull(message = "speciality is necessary")
    @Size(max=99,message = "incorrect length")
    private Set<Speciality> specialities = new HashSet<>();

    public void setVet(Vet vet){
        this.setFirstName(vet.getFirstName());
        this.setLastName(vet.getLastName());
        this.specialities=vet.specialities;
    }


}
