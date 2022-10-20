/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.controllers;

import com.server.animexlatam.entidades.Estado;
import com.server.animexlatam.entidades.Rol;
import com.server.animexlatam.services.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bryan
 */
@Controller
@RequestMapping("/api/rol")
public class RolController {
    
    @Autowired
    private RolService rolSvc;
    
    @GetMapping()
    private ResponseEntity<List<Rol>> optenerEstados() {
        return ResponseEntity.ok(this.rolSvc.FindAllModels());
    }
}
