package com.example.CurdSuperMercado.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CurdSuperMercado.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {
    // public abstract ArrayList<ProductoModel> findByNombre(String nombre);
}
