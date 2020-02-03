package com.kamil.petclinic.model;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "pets")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    public void setOwner(Owner owner){
        this.setFirstName(owner.getFirstName());
        this.setLastName(owner.getLastName());
        this.city = owner.city;
        this.address = owner.address;
        this.telephone = owner.telephone;
        this.pets = owner.pets;
    }

}
