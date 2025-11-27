package com.backend.summia.errors;

public class UsernameAlreadyExists extends RuntimeException{
    
    public UsernameAlreadyExists(){
        super("Username já existe");
    }
}
