package com.springbackendapirest.service;

import com.springbackendapirest.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario> listarUsurios();
    public Optional<Usuario> buscarPorId(Long id);
    public Usuario guardar(Usuario usuario);
    public void eliminar(Long id);
}
