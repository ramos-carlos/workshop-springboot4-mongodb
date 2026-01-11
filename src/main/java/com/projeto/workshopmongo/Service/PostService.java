package com.projeto.workshopmongo.Service;

import com.projeto.workshopmongo.Repository.PostRepository;
import com.projeto.workshopmongo.Service.Exception.ObjectNotFoundException;
import com.projeto.workshopmongo.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
