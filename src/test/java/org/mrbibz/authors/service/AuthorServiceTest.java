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
    private QuestRepository questRepository;

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
        ** QUEST MANAGEMENT TESTS  START**
     */
    @Test
    public void createQuestTest() {
        Quest quest = new Quest();

        when(questRepository.save(any(Quest.class))).thenReturn(any(Quest.class));

        authorService.createQuest(quest);

        verify(questRepository, times(1)).save(any(Quest.class));
    }

    @Test
    public void updateQuestTest() {
        Quest quest = new Quest();

        when(questRepository.save(any(Quest.class))).thenReturn(any(Quest.class));
    }
    /*
        ** QUEST MANAGEMENT TESTS  END**
     */
}
