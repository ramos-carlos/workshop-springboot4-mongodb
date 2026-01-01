package com.projeto.workshopmongo.Service;

import com.projeto.workshopmongo.DTO.UserDTO;
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

    //pesquisar todos
    public List<User> findAll() {
        return repository.findAll();
    }

    //pesquisar por ID
    public User findById(String id) {
        //se nao existir o ID ele retorna nulo
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    //inserir
    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
