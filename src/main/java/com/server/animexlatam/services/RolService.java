/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.services;

import com.server.animexlatam.entidades.Rol;
import com.server.animexlatam.exepciones.ResourceNotFoundExeption;
import com.server.animexlatam.exepciones.ResourceRedundatExeption;
import com.server.animexlatam.repositories.IRolRepository;
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
public class RolService implements IGenericService<Rol> {

    @Autowired
    private IRolRepository rolRepo;

    @Override
    public Rol saveModel(Rol modelo) {
        Optional<Rol> search = this.rolRepo.findByNombre(modelo.getNombre());
        if (!search.isPresent()) {
            return this.rolRepo.save(modelo);
        }
        throw new ResourceRedundatExeption("Esta Registro ya Existe");
    }

    @Override
    public List<Rol> FindAllModels() {
        return this.rolRepo.findAll();
    }

    @Override
    public Page<Rol> FindAllModelsByPages(Pageable pageable) {
        return this.rolRepo.findAll(pageable);
    }

    @Override
    public Optional<Rol> FindModel(long id) {
        Optional<Rol> search = this.rolRepo.findById(id);
        if (search.isPresent()) {
            return search;
        }
        throw new ResourceNotFoundExeption("Este Registro no Existe");
    }

    @Override
    public boolean updateModel(Rol modelo) {
        Optional<Rol> search = this.rolRepo.findById(modelo.getId());
        if (search.isPresent()) {
            search.get().setNombre(modelo.getNombre());
            search.get().setEstado(modelo.getEstado());
            search.get().setUsuarios(modelo.getUsuarios());
            search.get().setUpdateAt(LocalDateTime.now());
            this.rolRepo.save(search.get());
            return true;
        }
        throw new ResourceNotFoundExeption("Este Registro no Existe");
    }

    @Override
    public boolean deleteModel(long id) {
        Optional<Rol> search = this.rolRepo.findById(id);
        if (search.isPresent()) {
            this.rolRepo.delete(search.get());
            return true;
        }
        throw new ResourceNotFoundExeption("Este Registro no Existe");
    }
}
