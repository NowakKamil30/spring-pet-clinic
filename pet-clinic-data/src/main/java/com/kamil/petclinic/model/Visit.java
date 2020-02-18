package com.kamil.petclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name = "date")
    @NotNull(message = "date is necessary")
    private LocalDate date;

    @Column(name = "description")
    @NotNull(message = "description is necessary")
    @NotEmpty(message = "description is necessary")
    @Size(min=1, max=200, message = "incorrect length")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @NotNull(message = "pet is necessary")
    //@JsonBackReference
    private Pet pet;

    public void setVisit(Visit visit){
        this.date = visit.date;
        this.description = visit.description;
        this.pet = visit.pet;
    }

}
