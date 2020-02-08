package com.kamil.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialities")
public class Speciality extends  BaseEntity {

    @Column(name = "description")
    @NotNull(message = "description is necessary")
    @Size(min=2,max=100,message = "incorrect length")
    private String description;

    public void setSpeciality(Speciality speciality){
        this.description = speciality.description;
    }

}
