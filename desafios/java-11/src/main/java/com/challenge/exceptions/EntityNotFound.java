package com.challenge.exceptions;

public class EntityNotFound  extends RuntimeException{

    public EntityNotFound(String entity){
        super(entity + " not found");
    }
}
