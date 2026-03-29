package org.proy.apiconnect.service;

import org.proy.apiconnect.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductoService {
    private WebClient webClient;

    @Autowired
    public ProductoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Producto> getProductoById(int id){
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Producto.class);
    }

    public Mono<List<Producto>> getAllProducts(){
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Producto.class)
                .collectList();
    }

    public Mono<Producto> saveProduct(Producto producto){
        return webClient.post()
                .uri("/products")
                .bodyValue(producto)
                .retrieve()
                .bodyToMono(Producto.class);

    }
}
