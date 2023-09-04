package com.example.CurdSuperMercado.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CurdSuperMercado.models.ProductoModel;
import com.example.CurdSuperMercado.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @CrossOrigin
    @GetMapping()
    public ArrayList<ProductoModel> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @CrossOrigin
    @PostMapping()
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
        return this.productoService.guardarProducto(producto);
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public Optional<ProductoModel> obtenerPorId(@PathVariable("id") Long id) {
        return this.productoService.obtenerPorId(id);
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.productoService.eliminarUsuario(id);
        if (ok) {
            return "Se elimino el producto con id " + id;
        } else {
            return "No pudo eliminar el usuario con id " + id;
        }
        
    }
    
}