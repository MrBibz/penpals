package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mrbibz.authors.model.*;
import org.mrbibz.authors.repository.*;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final RelationshipRepository relationshipRepository;

    private final PostRepository postRepository;

    private final QuestRepository questRepository;

    private final QueryRepository queryRepository;

    public Author createAuthor(Author author) {
        Objects.requireNonNull(author);
        return authorRepository.save(author);
    }

    public Relationship addAuthor(Author requestSender, Author requestReceiver) {
        Objects.requireNonNull(requestSender);
        Objects.requireNonNull(requestReceiver);
        return relationshipRepository.save(new Relationship(requestSender, requestReceiver));
    }

    public Post createPost(Post post) {
        Objects.requireNonNull(post);
        return postRepository.save(post);
    }

    public Quest createQuest(Quest quest) {
        Objects.requireNonNull(quest);
        return questRepository.save(quest);
    }

    public Author updateAccount(Author updatedAuthor) {
        Objects.requireNonNull(updatedAuthor);
        return authorRepository.save(updatedAuthor);
    }

    public Query sendQuery(Query query) {
        Objects.requireNonNull(query);
        return queryRepository.save(query);
    }

    public Query unsendQuery(String queryId) {
        Objects.requireNonNull(queryId);
        queryRepository.deleteById(queryId);
        return queryRepository.findById(queryId).orElse(null);
    }
}
