/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.repositories;

import com.server.animexlatam.entidades.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Bryan
 */
public interface IGeneroRepository extends JpaRepository<Genero, Long>{
    
}
