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

    @InjectMocks
    private AuthorService authorService;

    private Author author1;

    @BeforeEach
    public void setUp() {
        author1 = new Author();

        when(authorRepository.save(any(Author.class))).thenReturn(any(Author.class));

        authorService.createAuthor(author1);
    }

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
    public void addFriendTest() {
        Author author2 = new Author();

        when(relationshipRepository.save(any(Relationship.class))).thenReturn(any(Relationship.class));

        authorService.addFriend(author1, author2);

        verify(authorRepository, times(1)).save(any(Author.class));
        verify(relationshipRepository, times(1)).save(any(Relationship.class));
    }

    @Test
    public void removeFriendTest() {
        Author author2 = new Author();
        Relationship relationship = new Relationship(author1, author2);

        when(relationshipRepository.save(any(Relationship.class))).thenReturn(relationship);
        when(relationshipRepository.findByFriends(any(Author.class), any(Author.class))).thenReturn(relationship);

        authorService.addFriend(author1, author2);
        authorService.removeFriend(author1, author2);

        verify(relationshipRepository, times(1)).delete(relationship);
    }
}
