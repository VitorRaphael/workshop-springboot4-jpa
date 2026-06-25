package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Registrando essa classe como um serviço do Spring
@Service
public class CategoryService {

    // Para podermos podermos implementar 2 operações de busca de usuário, temos que criar
    // a dependencia do UserService para o UserRepository

    @Autowired
    private CategoryRepository repository;

    // Criando o metódo para retornar todos os usuários do banco de dados
    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
