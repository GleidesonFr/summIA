package com.backend.summia.exceptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound(){
        super("Usuário não encontrado");
    }
    
}
