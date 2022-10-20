/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.services;

import com.server.animexlatam.entidades.Estado;
import com.server.animexlatam.repositories.IEstadoRepository;
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
public class EstadoService implements IGenericService<Estado> {

    @Autowired
    private IEstadoRepository estadoRepo;

    @Override
    public Estado saveModel(Estado modelo) {
        Optional<Estado> search = this.estadoRepo.findById(modelo.getId());
        if (!search.isPresent()) {
            return this.estadoRepo.save(modelo);
        }
        return null;
    }

    @Override
    public List<Estado> FindAllModels() {
        return this.estadoRepo.findAll();
    }

    @Override
    public Page<Estado> FindAllModelsByPages(Pageable pageable) {
        return this.estadoRepo.findAll(pageable);
    }

    @Override
    public Optional<Estado> FindModel(long id) {
        Optional<Estado> search = this.estadoRepo.findById(id);
        if (search.isPresent()) {
            return search;
        }
        return null;
    }

    @Override
    public boolean updateModel(Estado modelo) {
        Optional<Estado> search = this.FindModel(modelo.getId());
        if (search.isPresent()) {
            this.estadoRepo.save(modelo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteModel(long id) {
        Optional<Estado> search = this.FindModel(id);
        if (search.isPresent()) {
            this.estadoRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
