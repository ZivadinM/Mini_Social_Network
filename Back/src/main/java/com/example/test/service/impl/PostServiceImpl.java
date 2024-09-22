package com.example.test.service.impl;

import com.example.test.model.Post;
import com.example.test.model.PostDTO;
import com.example.test.model.User;
import com.example.test.repository.PostRepository;
import com.example.test.repository.UserRepository;
import com.example.test.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.test.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public PostServiceImpl(final PostRepository postRepository,final UserRepository userRepository,final UserService userService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Post> findPostById(int id) {
        return postRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Post> findPostByOwner(int owner) {
        return postRepository.findPostByOwner(owner);
    }

    @Override
    @Transactional
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public boolean existsById(int id) {
        return userRepository.existsById(id);
    }

    @Override
    @Transactional
    public Post updatePost(int id, Post post) {
        Post postt = postRepository.findById(id).orElseThrow();
        postt.setTitle(post.getTitle());
        postt.setDescription(post.getDescription());
        postt.setPicture(post.getPicture());
        return postt;
    }
    @Override
    @Transactional
    public List<PostDTO> getPostsByOwnerJmbg() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> {
                    Optional<User> owner = userService.findById(post.getOwner());
                    return new PostDTO(post, owner.orElse(null));
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<PostDTO> getPostsById(int id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            Optional<User> owner = userService.findById(post.getOwner());
            return Optional.of(new PostDTO(post, owner.orElse(null)));
        }
        return Optional.empty();
    }

    private void compareAndUpdatePost(Post currentPost, String title) {
        if (!currentPost.compare(title)) {
            currentPost.setTitle(
                    title == null ? currentPost.getTitle() : title
            );
        }
    }

    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }
}
