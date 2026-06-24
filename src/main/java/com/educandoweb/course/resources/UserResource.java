package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;

// Para a gente falar que essa classe é um recurso web implementado por um controlador Reste nos vamos ter
// que colocar uma anotation em cima da nome da classe
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    // Para indicar que esse método aqui vai ser um método que responde a requisição do tipo get do http
    // Vamos colocar aqui em cima do nosso método, um annotation chamado GetMapping
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gamil.com", "9999999", "12345");

        // O responseEntity ok serve para retornar que deu certo, que está ok, e o body(u) é para retornar
        // o espoco do meu corpo qu eu acabei de criar a cima no New User
        return ResponseEntity.ok().body(u);
    }
}
