/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.controllers;

import com.server.animexlatam.entidades.Estado;
import com.server.animexlatam.services.EstadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bryan
 */
@Controller
@RequestMapping("/api/estado")
public class EstadoController {
    
    @Autowired
    private EstadoService estadoSvc;
    
    @GetMapping()
    private ResponseEntity<List<Estado>> optenerEstados() {
        return ResponseEntity.ok(this.estadoSvc.FindAllModels());
    }
    
    @GetMapping("/{id}")
    private Estado optenerUnEstado(@PathVariable long id) {
        return this.estadoSvc.FindModel(id).get();
    }
    
    @PostMapping()
    private Estado crearEstado(@RequestBody Estado modelo) {
        return this.estadoSvc.saveModel(modelo);
    }
    
    @PutMapping()
    private boolean optenerEstados(@RequestBody Estado modelo) {
        return this.estadoSvc.updateModel(modelo);
    }
    
    @DeleteMapping("/{id}")
    private boolean optenerEstados(@PathVariable long id) {
        return this.estadoSvc.deleteModel(id);
    }
}
