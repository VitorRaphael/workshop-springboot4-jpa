package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

// Para a gente falar que essa classe é um recurso web implementado por um controlador Reste nos vamos ter
// que colocar uma anotation em cima da nome da classe
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    // Para indicar que esse método aqui vai ser um método que responde a requisição do tipo get do http
    // Vamos colocar aqui em cima do nosso método, um annotation chamado GetMapping
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // Inserindo um novo usuário no banco de dados
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);

        // Criando o retorno de ( 201 Criado ) ao invés de (200 ok )
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    // Criando método de deleter um id do banco de dados
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
