package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
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
        repository.deleteById(id);
    }

    // Retorna a atualização de um dado usuário
    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
