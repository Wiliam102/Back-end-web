package com.br.ifba.infraestructure.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;



@Component
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
    
}
