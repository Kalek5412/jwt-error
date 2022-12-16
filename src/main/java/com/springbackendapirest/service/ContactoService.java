package com.springbackendapirest.service;

import com.springbackendapirest.entidades.Contacto;

import java.util.List;
import java.util.Optional;

public interface ContactoService {
    public List<Contacto> listarContactos();
    public Optional<Contacto> buscarPorId(Long id);
    public Contacto guardar(Contacto contacto);
    public void eliminar(Long id);

}
