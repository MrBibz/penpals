package org.mrbibz.authors.repository;

import org.mrbibz.authors.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String>{
}
