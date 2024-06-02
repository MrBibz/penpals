package org.mrbibz.authors.repository;

import org.mrbibz.authors.model.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends MongoRepository<Query, String>{
}
