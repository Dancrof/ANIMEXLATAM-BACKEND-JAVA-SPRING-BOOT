/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.exepciones;

/**
 *
 * @author Bryan
 */
public class ResourceNotFoundExeption extends RuntimeException{

    public ResourceNotFoundExeption(String message) {
        super(message);
    }   
}
