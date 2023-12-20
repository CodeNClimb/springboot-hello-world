package com.example.storeApi.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Object object, int id) {
        super("The " + object.getClass().getSimpleName() + " with id '" + String.valueOf(id) + "' does not exist in our records");
    }
}
