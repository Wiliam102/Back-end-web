package com.br.ifba.infraestructure.usuario.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ifba.infraestructure.dto.UserResponseDto;
import com.br.ifba.infraestructure.exception.UserNotFoundException;
import com.br.ifba.infraestructure.usuario.entities.User;
import com.br.ifba.infraestructure.usuario.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@AllArgsConstructor
@RestController
@RequestMapping(path="/Usuarios")
public class UsuarioController {
    
     private final UsuarioService us;
    
   @GetMapping(path="/findall", produces="application/json")
   public ResponseEntity<List<UserResponseDto>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
    .body(this.us.listAll().stream().map(UserResponseDto::new).collect(Collectors.toList()));

   }
   
   @PostMapping(path="/save", consumes="application/json")
   public ResponseEntity<UserResponseDto> save(@RequestBody @Valid User u){
    // recebendo o usuario salvo
    User userSaved = us.save(u);
    // adicionando ao dto de resposta
    UserResponseDto userDto = new UserResponseDto(
      userSaved.getNome(), userSaved.getEmail());
    return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
   }

   @DeleteMapping(path="/delete/{id}", produces = "application/json")
   public ResponseEntity<Void> delete(@PathVariable("id") Long id){
     us.delete(id);
     
     return ResponseEntity.status(HttpStatus.GONE).build();
      
    } 
    
   @PutMapping(path="/update/{id}", consumes="application/json")
   public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid User u) throws UserNotFoundException{
       us.update(id,u);
      
      return ResponseEntity.status(HttpStatus.ACCEPTED).build();
       
   }
    
   
}
