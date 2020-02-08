package com.kamil.petclinic.model;

import jdk.jfr.Enabled;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER ,mappedBy = "owner")
    @NotNull(message = "pet is necessary")
    @Size(min=1,message = "pet is necessary")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    @NotNull(message = "address is necessary")
    @NotEmpty(message = "address is necessary")
    @Size(min=1, max=30,message = "incorrect length")
    private String address;

    @Column(name = "city")
    @NotNull(message = "city is necessary")
    @NotEmpty(message = "city is necessary")
    @Size(min=1, max=30,message = "incorrect length")
    private String city;

    @Column(name = "telephone")
    @NotNull(message = "phone number is necessary")
    @Pattern(regexp = "[0-9]{9}", message = "this is not phone number(pattern 111111111")
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
