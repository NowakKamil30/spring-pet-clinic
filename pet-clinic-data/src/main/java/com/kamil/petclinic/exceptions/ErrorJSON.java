package com.kamil.petclinic.exceptions;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorJSON {
        private String message;
}
