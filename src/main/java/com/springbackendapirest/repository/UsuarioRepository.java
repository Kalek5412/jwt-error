package com.springbackendapirest.repository;

import com.springbackendapirest.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findOneByEmail(String email);
}
