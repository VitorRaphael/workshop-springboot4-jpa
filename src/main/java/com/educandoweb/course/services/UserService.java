package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

// Registrando essa classe como um serviço do Spring
@Service
public class UserService {

    // Para podermos podermos implementar 2 operações de busca de usuário, temos que criar
    // a dependencia do UserService para o UserRepository

    @Autowired
    private UserRepository repository;

    // Criando o metódo para retornar todos os usuários do banco de dados
    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Retorna o usuário salvo
    public User insert(User obj) {
        return repository.save(obj);
    }

    // Retorna a deleção de um usuário
    public void delete(Long id) {
        // 1. Primeiro verificamos se o registro existe
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        // 2. Tentamos deletar e tratamos a violação de integridade
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation: cannot delete");
        }
    }

    // Retorna a atualização de um dado usuário
    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
