package com.projeto.workshopmongo.Resource;

import com.projeto.workshopmongo.Resource.Util.URL;
import com.projeto.workshopmongo.Service.PostService;
import com.projeto.workshopmongo.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.awt.SystemColor.text;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    public PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
