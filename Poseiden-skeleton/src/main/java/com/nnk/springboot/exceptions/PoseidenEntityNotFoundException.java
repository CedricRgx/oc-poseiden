package com.nnk.springboot.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PoseidenEntityNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;
    private final int id;

    public PoseidenEntityNotFoundException(String message, int id){
        super(message);
        this.id = id;
    }

    @Override
    public String getMessage() {
        String message = "No with id " + id + " found";
        return getMessage();
    }
}
