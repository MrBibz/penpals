package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import org.mrbibz.authors.model.Post;
import org.mrbibz.authors.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(Post post) {
        Objects.requireNonNull(post, "Post cannot be null");
        return postRepository.save(post);
    }

    public Post editPost(Post post) {
        Objects.requireNonNull(post, "Post cannot be null");
        return postRepository.save(post);
    }

    public Optional<Post> deletePost(String postId) {
        Objects.requireNonNull(postId, "Post ID cannot be null");
        Optional<Post> post = postRepository.findById(postId);
        post.ifPresent(postRepository::delete);
        return post;
    }
}