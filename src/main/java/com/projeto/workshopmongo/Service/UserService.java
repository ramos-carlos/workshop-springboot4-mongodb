package com.projeto.workshopmongo.Service;

import com.projeto.workshopmongo.Repository.UserRepository;
import com.projeto.workshopmongo.Service.Exception.ObjectNotFoundException;
import com.projeto.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        //se nao existir o ID ele retorna nulo
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
