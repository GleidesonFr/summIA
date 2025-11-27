package com.backend.summia.errors;

public class EmailAlreadyExists extends RuntimeException{
    
    public EmailAlreadyExists(){
        super("Email já cadastrado");
    }
}
