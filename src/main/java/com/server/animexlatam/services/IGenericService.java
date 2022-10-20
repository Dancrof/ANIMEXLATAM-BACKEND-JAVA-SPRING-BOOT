/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.animexlatam.services;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Bryan
 * @param <T>
 */
public interface IGenericService<T> {

    public T saveModel(T modelo);

    public List<T> FindAllModels();

    public Page<T> FindAllModelsByPages(Pageable pageable);

    public Optional<T> FindModel(long id);

    public boolean updateModel(T modelo);

    public boolean deleteModel(long id);
}
