package com.kamil.petclinic.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    @ApiModelProperty(value = "this is pet type name", required = true)
    @Column(name = "name")
    @NotNull(message = "name is necessary")
    @NotEmpty(message = "name is necessary")
    @Size(min=2,max=20,message = "incorrect length")
    private String name;

    public void setPetType(PetType petType){
        this.name = petType.name;
    }


}
