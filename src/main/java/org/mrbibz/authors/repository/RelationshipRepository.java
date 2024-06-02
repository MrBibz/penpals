package org.mrbibz.authors.repository;

import org.mrbibz.authors.model.Relationship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends MongoRepository<Relationship, String> {
}
