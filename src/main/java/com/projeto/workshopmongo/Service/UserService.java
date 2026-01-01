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

    //deletar
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    //atualização
    public User update(User obj) {
        User newObj = repository.findById(obj.getId())
                        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}

