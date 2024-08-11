package com.br.ifba.infraestructure.dto;

import com.br.ifba.infraestructure.usuario.entities.User;

public record UserResponseDto(String nome, String email) {
   
    public UserResponseDto(User u){
     this(u.getNome(), u.getEmail());
   }
}
