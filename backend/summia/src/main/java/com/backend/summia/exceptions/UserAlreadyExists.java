package com.backend.summia.exceptions;

public class UserAlreadyExists extends RuntimeException{
    
    public UserAlreadyExists(){
        super("Já existe um usuário com esse nome");
    }
}
