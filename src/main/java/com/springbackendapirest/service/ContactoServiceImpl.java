package com.springbackendapirest.service;

import com.springbackendapirest.entidades.Contacto;
import com.springbackendapirest.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> listarContactos() {
        return contactoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contacto> buscarPorId(Long id) {
        return contactoRepository.findById(id);
    }

    @Override
    @Transactional
    public Contacto guardar(Contacto cliente) {
        return contactoRepository.save(cliente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        contactoRepository.deleteById(id);
    }


}
