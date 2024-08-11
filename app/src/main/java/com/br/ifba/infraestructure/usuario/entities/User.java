package com.br.ifba.infraestructure.usuario.entities;

import java.io.Serializable;
import com.br.ifba.infraestructure.entity.PersistenceEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name= "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends PersistenceEntity implements Serializable {
    
    @JsonProperty(value="nome")
    @NotNull(message="O nome eh obrigatório")
    @NotBlank(message="O nome não pode ser vazio")
    @Column(name= "nome", nullable= false)
    private String nome;
    
    @JsonProperty(value="email")
    @Email(message="formato de email inválido")
    @Column(name= "email", nullable = false, unique= true)
    private String email;
    
    
    @JsonProperty(value="login")
    @NotNull(message="O login eh obrigatório!")
    @NotBlank(message="O login não pode ser vazio!")
    @Size(min=3, max=30, message = "O minimo de caracteres é 3 e o maximo é 30!")
    @Column(name= "login", nullable = false, unique=true)
    private String login;
    
    
    @JsonProperty(value="senha")
    @NotNull(message="a senha é obrigatória!")
    @NotBlank(message="a senha não pode ser vazia!")
    @Column(name= "senha", nullable = false, unique=true)
    private String senha;
}
