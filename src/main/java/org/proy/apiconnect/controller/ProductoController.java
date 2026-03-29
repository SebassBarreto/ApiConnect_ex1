package org.proy.apiconnect.controller;

import org.proy.apiconnect.model.Producto;
import org.proy.apiconnect.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("/getProductById/{id}")
    public Mono<Producto> getProductoById(@PathVariable int id){
        return productoService.getProductoById(id);
    }

    @GetMapping("/getAllProducts")
    public Mono<List<Producto>> getAllProducts(){
        return productoService.getAllProducts();
    }

    @PostMapping("/createProduct")
    public Mono<Producto> saveProduct(Producto producto){
        return productoService.saveProduct(producto);
    }
}
