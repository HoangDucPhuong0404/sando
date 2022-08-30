package com.cg.tp.sandro.services;

import com.cg.team_project2.model.Product;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {


    List<T> findAll();

    Optional<T> findById(Long id);

    T getById(Long id);

    T save(T t);

    void remove(Long id);
}
