package com.br.ifba.infraestructure.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.ifba.infraestructure.usuario.entities.User;


@Repository
public interface UsuarioRepositorio extends JpaRepository<User,Long> {
   User findUserById(Long id);
  
}
