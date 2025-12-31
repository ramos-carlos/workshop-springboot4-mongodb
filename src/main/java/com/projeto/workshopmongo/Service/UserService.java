package com.projeto.workshopmongo.Service;

import com.projeto.workshopmongo.Repository.UserRepository;
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
}
