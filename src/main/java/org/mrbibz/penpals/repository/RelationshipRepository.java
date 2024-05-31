package org.mrbibz.penpals.repository;

import org.mrbibz.penpals.model.Relationship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends MongoRepository<Relationship, String> {
}
