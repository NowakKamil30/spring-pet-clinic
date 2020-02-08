package com.kamil.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {
    
    @Column(name = "first_name")
    @NotNull(message = "first name is necessary")
    @Size(min=2,max=20,message = "incorrect length")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "last name is necessary")
    @Size(min=2,max=20,message = "incorrect length")
    private String lastName;

}
