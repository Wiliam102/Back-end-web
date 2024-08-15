package com.br.ifba.infraestructure.usuario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.ifba.infraestructure.exception.UserNotFoundException;
import com.br.ifba.infraestructure.usuario.entities.User;
import com.br.ifba.infraestructure.usuario.repository.UsuarioRepositorio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {
 private final UsuarioRepositorio ur;

 @Transactional
 public Page<User> findAll(Pageable pageable){
    return ur.findAll(pageable);

 }
 @Transactional
 public User save(User u){
      return ur.save(u);
      
 }
 
     @Transactional
     public void update(Long id, User u)throws UserNotFoundException{
    if (ur.existsById(id)) {
        // Recuperar o usuário existente do banco de dados
        User userExistente = ur.findUserById(id);

        // Atualizar os campos com os novos valores
        userExistente.setNome(u.getNome());
        userExistente.setEmail(u.getEmail());
        userExistente.setLogin(u.getLogin());
        userExistente.setSenha(u.getSenha());

        // Salvar o usuário atualizado no banco de dados
        ur.save(userExistente);

    }
    throw new UserNotFoundException();
        
}

 @Transactional
 public void delete(long id) throws UserNotFoundException{
    if(ur.existsById(id)){
    ur.deleteById(id);
    }
    throw new UserNotFoundException();
    }

}
