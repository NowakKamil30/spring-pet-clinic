package com.kamil.petclinic.controller;

import com.kamil.petclinic.exceptions.ErrorJSON;
import com.kamil.petclinic.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorJSON> handleNumberFormat(Exception e){
        return new ResponseEntity<>(new ErrorJSON(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorJSON> handleNotFound(Exception e){
        return new ResponseEntity<>(new ErrorJSON(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
