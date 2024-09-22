package com.example.test.service;

import com.example.test.model.Post;
import com.example.test.model.PostDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAllPosts();

    Post savePost(Post post);

    Optional<Post> findPostById(int id);

    List<PostDTO> getPostsByOwnerJmbg();

    Optional<PostDTO> getPostsById(int id   );

    List<Post> findPostByOwner(int owner);

    Post updatePost(int id, Post post);

    void deletePost(int postId);

    boolean existsById(int id);
}
