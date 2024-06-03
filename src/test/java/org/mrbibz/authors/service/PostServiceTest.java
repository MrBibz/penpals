package org.mrbibz.authors.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mrbibz.authors.model.Post;
import org.mrbibz.authors.repository.PostRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    private Post post;

    @BeforeEach
    public void setUp() {
        post = new Post();

        when(postRepository.save(any(Post.class))).thenReturn(any(Post.class));

        postService.createPost(post);
    }

    @Test
    public void createPostTest() {
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    public void updatePostTest() {
        postService.editPost(post);

        verify(postRepository, times(2)).save(any(Post.class));
    }

    @Test
    public void deletePostTest() {
        post.setId("postId");

        postService.deletePost(post.getId());

        verify(postRepository, times(1)).save(post);
        verify(postRepository, times(1)).deleteById(post.getId());
    }
}
