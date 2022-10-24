/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.services;

import com.server.animexlatam.entidades.Rol;
import com.server.animexlatam.entidades.Usuario;
import com.server.animexlatam.exepciones.ResourceRedundatExeption;
import com.server.animexlatam.repositories.IRolRepository;
import com.server.animexlatam.repositories.IUsuarioRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan
 */
@Service
public class UsuarioService implements IGenericService<Usuario> {

    @Autowired
    private IUsuarioRepository usuarioRepo;
    
    @Autowired
    private IRolRepository rolRepo;

    @Override
    public Usuario saveModel(Usuario modelo) {
        Optional<Usuario> search = this.usuarioRepo.findByUsername(modelo.getUsername());
        if (!search.isPresent()) {
            return this.usuarioRepo.save(modelo);
        }
        throw new ResourceRedundatExeption("Registro ya existente");
    }

    @Override
    public List<Usuario> FindAllModels() {
        return this.usuarioRepo.findAll();
    }

    @Override
    public Page<Usuario> FindAllModelsByPages(Pageable pageable) {
        return this.usuarioRepo.findAll(pageable);
    }

    @Override
    public Optional<Usuario> FindModel(long id) {
        Optional<Usuario> search = this.usuarioRepo.findById(id);
        if (search.isPresent()) {
            return search;
        }
        throw new ResourceRedundatExeption("Registro no existente");
    }

    @Override
    public boolean updateModel(Usuario modelo) {
        Optional<Usuario> search = this.usuarioRepo.findById(modelo.getId());
        Optional<Rol> searchRol = this.rolRepo.findById(modelo.getRol().getId());
        if (search.isPresent()) {
            search.get().setUsername(modelo.getUsername());
            search.get().setPassword(modelo.getPassword());
            search.get().setRol(searchRol.get());
            search.get().setUpdateAt(LocalDateTime.now());
            this.usuarioRepo.save(search.get());
            return true;
        }
        throw new ResourceRedundatExeption("Registro no existente");
    }

    @Override
    public boolean deleteModel(long id) {
        Optional<Usuario> search = this.usuarioRepo.findById(id);
        if (search.isPresent()) {           
            this.usuarioRepo.delete(search.get());
            return true;
        }
        throw new ResourceRedundatExeption("Registro no existente");
    }

}
