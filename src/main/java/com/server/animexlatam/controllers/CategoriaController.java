/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.controllers;

import com.server.animexlatam.entidades.Categoria;
import com.server.animexlatam.entidades.Estado;
import com.server.animexlatam.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaSvc;
    
    @GetMapping()
    private ResponseEntity<List<Categoria>> optenerCategorias() {
        return ResponseEntity.ok(this.categoriaSvc.FindAllModels());
    }
    
    @GetMapping("/{id}")
    private Categoria optenerUnaCategoria(@PathVariable long id) {
        return this.categoriaSvc.FindModel(id).get();
    }
    
    @PostMapping()
    private Categoria crearCategoria(@RequestBody Categoria modelo) {
        return this.categoriaSvc.saveModel(modelo);
    }
    
    @PutMapping()
    private boolean editarCategoria(@RequestBody Categoria modelo) {
        return this.categoriaSvc.updateModel(modelo);
    }
    
    @DeleteMapping("/{id}")
    private boolean eliminarCategoria(@PathVariable long id) {
        return this.categoriaSvc.deleteModel(id);
    }
}
