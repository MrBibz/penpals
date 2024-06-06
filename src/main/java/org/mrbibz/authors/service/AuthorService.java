package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import org.mrbibz.authors.model.*;
import org.mrbibz.authors.repository.*;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final RelationshipRepository relationshipRepository;

    public Author createAuthor(Author author) {
        Objects.requireNonNull(author, "Author cannot be null");
        return authorRepository.save(author);
    }

    public Relationship addFriend(Author requestSender, Author requestReceiver) {
        Objects.requireNonNull(requestSender, "Request sender cannot be null");
        Objects.requireNonNull(requestReceiver, "Request receiver cannot be null");
        return relationshipRepository.save(new Relationship(requestSender, requestReceiver));
    }

    public Author updateAccount(Author updatedAuthor) {
        Objects.requireNonNull(updatedAuthor, "Updated author cannot be null");
        return authorRepository.save(updatedAuthor);
    }

    public Optional<Relationship> removeFriend(Author friendRemover, Author friend) {
        Objects.requireNonNull(friendRemover, "Friend remover cannot be null");
        Objects.requireNonNull(friend, "Friend cannot be null");
        Relationship relationship = relationshipRepository.findByFriends(friendRemover, friend);
        if (relationship != null) {
            relationshipRepository.delete(relationship);
            return Optional.of(relationship);
        }
        return Optional.empty();
    }
}