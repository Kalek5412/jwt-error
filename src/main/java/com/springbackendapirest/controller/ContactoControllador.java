package com.springbackendapirest.controller;

import com.springbackendapirest.entidades.Contacto;
import com.springbackendapirest.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/contacto")
public class ContactoControllador {
    @Autowired
    private ContactoRepository contactoRepository;

   @GetMapping
    public List<Contacto> listContacto(){
       return contactoRepository.findAll();
   }
}
