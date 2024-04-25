package com.prueba.domain.exeption;

public class AdminIdNotFoundException extends RuntimeException{

    public AdminIdNotFoundException(String message){
        super(message);
    }
}
