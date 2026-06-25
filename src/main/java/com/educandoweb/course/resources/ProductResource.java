package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

// Para a gente falar que essa classe é um recurso web implementado por um controlador Reste nos vamos ter
// que colocar uma anotation em cima da nome da classe
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    // Para indicar que esse método aqui vai ser um método que responde a requisição do tipo get do http
    // Vamos colocar aqui em cima do nosso método, um annotation chamado GetMapping
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
