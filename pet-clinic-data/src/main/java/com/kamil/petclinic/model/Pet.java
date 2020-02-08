package com.kamil.petclinic.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    @NotNull(message = "name is necessary")
    @Size(min=2,max=20,message = "incorrect length")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @NotNull(message = "pet has to have type")
    private PetType petType;

    @Column(name = "birth_date")
    @NotNull(message = "birth date is necessary")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @NotNull(message = "pet has to have owner")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    @Size(max=99,message = "pet cannot have more than 99 visits")
    private Set<Visit> visits = new HashSet<>();

    public void setPet(Pet pet){
        this.name =  pet.name;
        this.petType = pet.petType;
        this.birthDate = pet.birthDate;
        this.visits = pet.visits;
        this.owner = pet.owner;
    }


}
