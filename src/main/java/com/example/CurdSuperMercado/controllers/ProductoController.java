package com.example.CurdSuperMercado.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CurdSuperMercado.models.ProductoModel;
import com.example.CurdSuperMercado.services.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @CrossOrigin
    @GetMapping("/consulta")
    public ArrayList<ProductoModel> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @CrossOrigin
    @PostMapping("/alta")
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
        return this.productoService.guardarProducto(producto);
    }

    @CrossOrigin
    @PutMapping("/modificacion")
    public ProductoModel modificarProducto(@RequestBody ProductoModel producto) {
        return this.productoService.guardarProducto(producto);
    }

    @CrossOrigin
    @GetMapping(path = "/consulta/{id}")
    public Optional<ProductoModel> obtenerPorId(@PathVariable("id") Long id) {
        return this.productoService.obtenerPorId(id);
    }

    @CrossOrigin
    @GetMapping(path = "/consulta/query")
    public ArrayList<ProductoModel> obtenerPorNombre(@RequestParam("nombre") String nombre) {
        return this.productoService.obtenerPorNombre(nombre);
    }

    @CrossOrigin
    @DeleteMapping(path = "/baja/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.productoService.eliminarUsuario(id);
        if (ok) {
            return "Se elimino el producto con id " + id;
        } else {
            return "No pudo eliminar el usuario con id " + id;
        }
        
    }
    
}