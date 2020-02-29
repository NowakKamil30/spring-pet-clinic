package com.kamil.petclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pet extends BaseEntity {

    @ApiModelProperty(value = "this is pet name", required = true)
    @Column(name = "name")
    @NotNull(message = "name is necessary")
    @NotEmpty(message = "name is necessary")
    @Size(min=2,max=20,message = "incorrect length")
    private String name;

    @ApiModelProperty(value = "this is petType", required = true)
    @ManyToOne
    @JoinColumn(name = "type_id")
    @NotNull(message = "pet has to have type")
    private PetType petType;

    @ApiModelProperty(value = "this is birth data", required = true)
    @Column(name = "birth_date")
    @NotNull(message = "birth date is necessary")
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate birthDate;

    @ApiModelProperty(value = "this is pet owner", required = true)
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @NotNull(message = "pet has to have owner")
   // @JsonBackReference
    private Owner owner;

    @ApiModelProperty(value = "this is a list of pet visits", required = true)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    @Size(max=99,message = "pet cannot have more than 99 visits")
    //@JsonManagedReference
    private Set<Visit> visits = new HashSet<>();

    public void setPet(Pet pet){
        this.name =  pet.name;
        this.petType = pet.petType;
        this.birthDate = pet.birthDate;
        this.visits = pet.visits;
        this.owner = pet.owner;
    }


}
