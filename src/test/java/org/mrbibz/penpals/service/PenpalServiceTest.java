package org.mrbibz.penpals.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mrbibz.penpals.model.Penpal;
import org.mrbibz.penpals.model.Post;
import org.mrbibz.penpals.model.Relationship;
import org.mrbibz.penpals.model.Writeoff;
import org.mrbibz.penpals.repository.PenpalRepository;
import org.mrbibz.penpals.repository.PostRepository;
import org.mrbibz.penpals.repository.RelationshipRepository;
import org.mrbibz.penpals.repository.WriteoffRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PenpalServiceTest {

    @Mock
    private PenpalRepository penpalRepository;

    @Mock
    private RelationshipRepository relationshipRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private WriteoffRepository writeoffRepository;

    @InjectMocks
    private PenpalService penpalService;

    private Penpal penpal1;

    @BeforeEach
    public void setUp() {
        penpal1 = new Penpal();
        penpalService.createPenpal(penpal1);
    }

    @Test
    public void createPenpalTest() {
        verify(penpalRepository, times(1)).save(penpal1);
    }

    @Test
    public void addPenpalTest() {
        Penpal penpal2 = new Penpal();

        when(relationshipRepository.save(any(Relationship.class))).thenReturn(any(Relationship.class));

        penpalService.addPenpal(penpal1, penpal2);

        verify(penpalRepository, times(1)).save(any(Penpal.class));
        verify(relationshipRepository, times(1)).save(any(Relationship.class));
    }

    @Test
    public void createPostTest() {
        Post post = new Post();

        when(postRepository.save(any(Post.class))).thenReturn(any(Post.class));

        penpalService.createPost(post);

        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    public void createEventTest() {
        Writeoff event = new Writeoff();

        when(writeoffRepository.save(any(Writeoff.class))).thenReturn(any(Writeoff.class));

        penpalService.createWriteoff(event);

        verify(writeoffRepository, times(1)).save(any(Writeoff.class));
    }
}
