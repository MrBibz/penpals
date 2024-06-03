package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import org.mrbibz.authors.model.*;
import org.mrbibz.authors.repository.*;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final RelationshipRepository relationshipRepository;

    private final QuestRepository questRepository;

    public Author createAuthor(Author author) {
        Objects.requireNonNull(author);
        return authorRepository.save(author);
    }

    public Relationship addAuthor(Author requestSender, Author requestReceiver) {
        Objects.requireNonNull(requestSender);
        Objects.requireNonNull(requestReceiver);
        return relationshipRepository.save(new Relationship(requestSender, requestReceiver));
    }

    public Quest createQuest(Quest quest) {
        Objects.requireNonNull(quest);
        return questRepository.save(quest);
    }

    public Author updateAccount(Author updatedAuthor) {
        Objects.requireNonNull(updatedAuthor);
        return authorRepository.save(updatedAuthor);
    }
}
