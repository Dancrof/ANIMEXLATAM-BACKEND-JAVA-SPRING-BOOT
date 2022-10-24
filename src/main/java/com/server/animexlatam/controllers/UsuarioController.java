/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.controllers;

import com.server.animexlatam.entidades.Usuario;
import com.server.animexlatam.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bryan
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioSvc;

    @GetMapping
    private ResponseEntity<List<Usuario>> todosLosUsuarios() {
        return ResponseEntity.ok(this.usuarioSvc.FindAllModels());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Usuario> unSoloUsuarios(@PathVariable long id) {
        return ResponseEntity.ok(this.usuarioSvc.FindModel(id).get());
    }

    @PostMapping
    private ResponseEntity<Usuario> crearUnUsuarios(@RequestBody Usuario modelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioSvc.saveModel(modelo));
    }
    
    @PutMapping
    private ResponseEntity<Boolean> editarUnUsuarios(@RequestBody Usuario modelo) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.usuarioSvc.updateModel(modelo));
    }
    
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> eliminarUnUsuarios(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.usuarioSvc.deleteModel(id));
    }
}
