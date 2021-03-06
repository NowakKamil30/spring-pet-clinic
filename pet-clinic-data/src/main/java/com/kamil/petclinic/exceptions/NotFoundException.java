package com.kamil.petclinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super();
    }
    public NotFoundException(String ms){
        super(ms);
    }
    public NotFoundException(String ms, Throwable cause){
        super(ms,cause);
    }
}
