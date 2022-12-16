package com.springbackendapirest.controller;

import com.springbackendapirest.entidades.Usuario;
import com.springbackendapirest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listadoDeClientes(){
       List<Usuario> lista=  usuarioService.listarUsurios();
       return ResponseEntity.ok(lista);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> detalleUsuario(@PathVariable Long id){
        Optional<Usuario> usuarioOp=usuarioService.buscarPorId(id);
        if(usuarioOp.isPresent()){
            return ResponseEntity.ok(usuarioOp.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
       return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuario));
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<?> editarUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
        Optional<Usuario> usuarioOp=usuarioService.buscarPorId(id);
        if(usuarioOp.isPresent()){
            Usuario usuarioBD = usuarioOp.get();
//            clienteBD.setNombre(cliente.getNombre());
//            clienteBD.setApellido(cliente.getApellido());
//            clienteBD.setEmail(cliente.getEmail());
        return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuarioBD));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
        Optional<Usuario> clienteOp=usuarioService.buscarPorId(id);
        if(clienteOp.isPresent()){
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
