package com.cg.tp.sandro.services;

<<<<<<< HEAD


=======
>>>>>>> df4aeeb880421e6530fc993a53affde79843fbf9
import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {


    List<T> findAll();

    Optional<T> findById(Long id);

    T getById(Long id);

    T save(T t);

    void remove(Long id);
}
