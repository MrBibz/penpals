package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import org.mrbibz.authors.model.Post;
import org.mrbibz.authors.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(Post post) {
        Objects.requireNonNull(post);
        return postRepository.save(post);
    }

    public Post deletePost(String postId) {
        Objects.requireNonNull(postId);
        Post post = postRepository.findById(postId).orElse(null);
        postRepository.deleteById(postId);
        return post;
    }

    public Post editPost(Post post) {
        Objects.requireNonNull(post);
        return postRepository.save(post);
    }
}
