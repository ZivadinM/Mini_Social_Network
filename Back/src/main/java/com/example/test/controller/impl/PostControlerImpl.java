package com.example.test.controller.impl;

import com.example.test.controller.PostControler;
import com.example.test.model.Post;
import com.example.test.model.PostDTO;
import com.example.test.repository.UserRepository;
import com.example.test.service.PostService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.test.service.UserService;

import java.awt.desktop.SystemEventListener;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*")
@RestController
public class PostControlerImpl implements PostControler{

    private UserRepository userRepository;


    private final PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostControlerImpl.class);

    public PostControlerImpl(final PostService postService) {
        this.postService = postService;
    }

    @Override
    public List<Post> getPost() {
        return postService.getAllPosts();
    }

    @Override
    public Optional<Post> getPostById(int id) {
        return postService.findPostById(id);
    }

    @Override
    public ResponseEntity<List<PostDTO>> getPostsByOwnerJmbg() {
        List<PostDTO> posts = postService.getPostsByOwnerJmbg();
        return ResponseEntity.ok(posts);
    }

    @Override
    public ResponseEntity<Optional<PostDTO>> getPostsById(int id) {
        Optional<PostDTO> posts = postService.getPostsById(id);
        return ResponseEntity.ok(posts);
    }

    @Override
    public List<Post> getPostByOwner(int owner) {
        return postService.findPostByOwner(owner);
    }

    public boolean existsById(int id) {
        return userRepository.existsById(id);
    }

    @Override
    public Post createPost(Post Post) {
        if (!postService.existsById(Post.getOwner())) {
            throw new IllegalArgumentException("Owner does not exist.");
        }
                Post post = new Post(Post.getId(), Post.getTitle(), Post.getDescription(), Post.getOwner(),Post.getPicture());
            return postService.savePost(post);
    }

    @Override
    public Post updatePost(int id, Post post) {

        return postService.updatePost(id, post);
    }

    @Override
    public ResponseEntity<Void> deletePost( int id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();}
    }