package com.kamil.petclinic.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    @ApiModelProperty(value = "this is first name", required = true)
    @Column(name = "first_name")
    @NotNull(message = "first name is necessary")
    @NotEmpty(message = "first name is necessary")
    @Size(min=2,max=20,message = "incorrect length")
    private String firstName;

    @ApiModelProperty(value = "this is last name", required = true)
    @Column(name = "last_name")
    @NotNull(message = "last name is necessary")
    @NotEmpty(message = "last name is necessary")
    @Size(min=2,max=20,message = "incorrect length")
    private String lastName;

}
