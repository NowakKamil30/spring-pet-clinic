package com.kamil.petclinic.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    @ApiModelProperty(value = "this is id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
