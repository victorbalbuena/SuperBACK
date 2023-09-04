package com.example.CurdSuperMercado.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CurdSuperMercado.models.CatalogoModel;
import com.example.CurdSuperMercado.repositories.CatalogoRepository;

@Service
public class CatalogoService {
    @Autowired
    CatalogoRepository catalogoRepository;

    public ArrayList<CatalogoModel> obtenerCatalogo() {
        return (ArrayList<CatalogoModel>) catalogoRepository.findAll();
    }

    public CatalogoModel guardarCatalogo(CatalogoModel catalogo) {
        return catalogoRepository.save(catalogo);
    }

    public Optional<CatalogoModel> obtenerPorId(Long id) {
        return catalogoRepository.findById(id);
    }

    public boolean eliminarCatalogo(Long id) {
        try {
            catalogoRepository.deleteById(id);
            return true;
        } catch(Exception err) {
            return false;
        }
    }
}
