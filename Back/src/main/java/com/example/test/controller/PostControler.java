package com.example.test.controller;

import com.example.test.model.Post;
import com.example.test.model.PostDTO;
import com.example.test.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/posts")
public interface PostControler {

    @PostMapping(consumes = "application/json", produces = "application/json")
    Post createPost(@RequestBody Post Post);

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable int id);

    @GetMapping("/user/{owner}")
    public List<Post> getPostByOwner(@PathVariable int owner);

    @GetMapping("/allwithusers")
    public ResponseEntity<List<PostDTO>> getPostsByOwnerJmbg();

    @GetMapping("/withuser/{id}")
    public ResponseEntity<Optional<PostDTO>> getPostsById(@PathVariable int id);

    @GetMapping()
    List<Post> getPost();

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    Post updatePost(@PathVariable int id,@RequestBody Post post);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id);
}
