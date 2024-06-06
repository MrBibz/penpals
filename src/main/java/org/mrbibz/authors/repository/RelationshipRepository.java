package org.mrbibz.authors.repository;

import org.mrbibz.authors.model.Author;
import org.mrbibz.authors.model.Relationship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends MongoRepository<Relationship, String> {

    @Query("{ $or: [ { 'firstAuthor' : ?0, 'secondAuthor' : ?1 }, { 'firstAuthor' : ?1, 'secondAuthor' : ?0 } ] }")
    Relationship findByFriends(Author friendRemover, Author friend);
}
