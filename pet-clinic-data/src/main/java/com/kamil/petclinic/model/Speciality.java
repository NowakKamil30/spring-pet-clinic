package com.kamil.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialities")
public class Speciality extends  BaseEntity {

    @Column(name = "description")
    private String description;

    public void setSpeciality(Speciality speciality){
        this.description = speciality.description;
    }

}
