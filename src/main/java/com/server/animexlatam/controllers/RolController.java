/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.controllers;

import com.server.animexlatam.entidades.Rol;
import com.server.animexlatam.services.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bryan
 */
@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private RolService rolSvc;

    @GetMapping
    private ResponseEntity<List<Rol>> optenerLista() {

        return ResponseEntity.ok(this.rolSvc.FindAllModels());
    }
    
    @PostMapping
    private ResponseEntity<Rol> crearRol(@RequestBody Rol modelo) {

        return ResponseEntity.ok(this.rolSvc.saveModel(modelo));
    }
}
