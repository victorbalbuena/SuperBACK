package com.example.CurdSuperMercado.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CurdSuperMercado.models.CatalogoModel;
import com.example.CurdSuperMercado.services.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    @Autowired
    CatalogoService catalogoService;

    @GetMapping()
    public ArrayList<CatalogoModel> obtenerCatalogos() {
        return catalogoService.obtenerCatalogo();
    }

    @PostMapping()
    public CatalogoModel guardarModel(@RequestBody CatalogoModel catalogo) {
        return this.catalogoService.guardarCatalogo(catalogo);
    }

    @GetMapping(path = "/{id}")
    public Optional<CatalogoModel> obtenerPorId(@PathVariable("id") Long id) {
        return this.catalogoService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.catalogoService.eliminarCatalogo(id);
        if (ok) {
            return "Se elimino el catalogo con id " + id;
        } else {
            return "No pudo eliminar el catalogo con id " + id;
        }
    }
}
