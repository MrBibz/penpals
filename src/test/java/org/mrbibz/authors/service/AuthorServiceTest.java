package org.mrbibz.authors.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mrbibz.authors.model.*;
import org.mrbibz.authors.repository.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private RelationshipRepository relationshipRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private QuestRepository questRepository;

    @Mock
    private QueryRepository queryRepository;

    @InjectMocks
    private AuthorService authorService;

    private Author author1;

    @BeforeEach
    public void setUp() {
        author1 = new Author();
        authorService.createAuthor(author1);
    }

    /*
        ** ACCOUNT MANAGEMENT TESTS  START**
     */
    @Test
    public void createAuthorTest() {
        verify(authorRepository, times(1)).save(author1);
    }

    @Test
    public void updateAccount() {
        Author updatedAuthor = new Author();

        when(authorRepository.save(any(Author.class))).thenReturn(updatedAuthor);

        authorService.updateAccount(updatedAuthor);

        verify(authorRepository, times(1)).save(updatedAuthor);
    }

    @Test
    public void addAuthorTest() {
        Author author2 = new Author();

        when(relationshipRepository.save(any(Relationship.class))).thenReturn(any(Relationship.class));

        authorService.addAuthor(author1, author2);

        verify(authorRepository, times(1)).save(any(Author.class));
        verify(relationshipRepository, times(1)).save(any(Relationship.class));
    }
    /*
        ** ACCOUNT MANAGEMENT TESTS  END**
     */

    /*
        ** QUERY MANAGEMENT TESTS  START**
     */
    @Test
    public void sendQueryTest() {
        Query query = new Query();

        when(queryRepository.save(any(Query.class))).thenReturn(any(Query.class));

        authorService.sendQuery(query);

        verify(queryRepository, times(1)).save(any(Query.class));
    }

    @Test
    public void unsendQueryTest() {
        Query query = new Query();
        query.setId("queryId");

        when(queryRepository.save(any(Query.class))).thenReturn(query);

        authorService.sendQuery(query);
        authorService.unsendQuery(query.getId());

        verify(queryRepository, times(1)).save(query);
        verify(queryRepository, times(1)).deleteById(query.getId());
    }
    /*
        ** QUERY MANAGEMENT TESTS  END**
     */

    /*
        ** POST MANAGEMENT TESTS  START**
     */
    @Test
    public void createPostTest() {
        Post post = new Post();

        when(postRepository.save(any(Post.class))).thenReturn(any(Post.class));

        authorService.createPost(post);

        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    public void updatePostTest() {
        Post post = new Post();

        when(postRepository.save(any(Post.class))).thenReturn(any(Post.class));

        authorService.createPost(post);

        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    public void deletePostTest() {
        Post post = new Post();
        post.setId("postId");

        when(postRepository.save(any(Post.class))).thenReturn(post);

        authorService.createPost(post);
        authorService.deletePost(post.getId());

        verify(postRepository, times(1)).save(post);
        verify(postRepository, times(1)).deleteById(post.getId());
    }
    /*
        ** POST MANAGEMENT TESTS  END**
     */

    @Test
    public void createQuestTest() {
        Quest quest = new Quest();

        when(questRepository.save(any(Quest.class))).thenReturn(any(Quest.class));

        authorService.createQuest(quest);

        verify(questRepository, times(1)).save(any(Quest.class));
    }
}
