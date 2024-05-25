package com.nnk.springboot.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PoseidonEntityNotFoundException extends EntityNotFoundException {

    private String message;
    private int id;

    public PoseidonEntityNotFoundException(String message, int id){
        super(message);
        this.id = id;
    }

    @Override
    public String getMessage() {
        String message = "No with id " + id + " found";
        return message;
    }
}
