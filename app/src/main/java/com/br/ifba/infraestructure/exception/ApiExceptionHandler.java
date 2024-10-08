package com.br.ifba.infraestructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundHandler(UserNotFoundException exception){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }
    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> generalException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de execução");
    }
}
