package com.example.CurdSuperMercado.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CurdSuperMercado.models.CatalogoModel;

@Repository
public interface CatalogoRepository extends CrudRepository<CatalogoModel, Long>{
    
}
