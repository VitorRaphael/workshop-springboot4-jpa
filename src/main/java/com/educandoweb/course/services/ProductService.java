package com.educandoweb.course.services;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Registrando essa classe como um serviço do Spring
@Service
public class ProductService {

    // Para podermos podermos implementar 2 operações de busca de usuário, temos que criar
    // a dependencia do UserService para o UserRepository

    @Autowired
    private ProductRepository repository;

    // Criando o metódo para retornar todos os usuários do banco de dados
    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
