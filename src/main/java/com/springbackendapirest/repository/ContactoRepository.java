package com.springbackendapirest.repository;

import com.springbackendapirest.entidades.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ContactoRepository extends JpaRepository<Contacto,Long> {
}
