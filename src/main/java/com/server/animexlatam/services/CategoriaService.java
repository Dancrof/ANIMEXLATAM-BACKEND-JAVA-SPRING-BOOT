/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.services;

import com.server.animexlatam.entidades.Categoria;
import com.server.animexlatam.exepciones.ResourceNotFoundExeption;
import com.server.animexlatam.exepciones.ResourceRedundatExeption;
import com.server.animexlatam.repositories.ICategoriaRepository;
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
public class CategoriaService implements IGenericService<Categoria> {

    @Autowired
    private ICategoriaRepository categoriaRepo;

    @Override
    public Categoria saveModel(Categoria modelo) {
        Optional<Categoria> search = this.categoriaRepo.findByNombre(modelo.getNombre());
        if (!search.isPresent()) {
            return this.categoriaRepo.save(modelo);
        }
        throw new ResourceRedundatExeption("Registro ya existente");
    }

    @Override
    public List<Categoria> FindAllModels() {
        return this.categoriaRepo.findAll();
    }

    @Override
    public Page<Categoria> FindAllModelsByPages(Pageable pageable) {
        return this.categoriaRepo.findAll(pageable);
    }

    @Override
    public Optional<Categoria> FindModel(long id) {
        Optional<Categoria> search = this.categoriaRepo.findById(id);
        if (search.isPresent()) {
            return search;
        }
        throw new ResourceNotFoundExeption("Registro no existente");
    }

    @Override
    public boolean updateModel(Categoria modelo) {
        Optional<Categoria> search = this.categoriaRepo.findById(modelo.getId());
        if (search.isPresent()) {
            search.get().setNombre(modelo.getNombre());
            search.get().setUpdateAt(LocalDateTime.now());
            this.categoriaRepo.save(search.get());
            return true;
        }
        throw new ResourceRedundatExeption("Registro no existente");
    }

    @Override
    public boolean deleteModel(long id) {
        Optional<Categoria> search = this.categoriaRepo.findById(id);
        if (search.isPresent()) {
            this.categoriaRepo.delete(search.get());
            return true;
        }
        throw new ResourceNotFoundExeption("Registro no existente");
    }

}
