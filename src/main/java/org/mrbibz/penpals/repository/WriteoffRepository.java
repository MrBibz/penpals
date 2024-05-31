package org.mrbibz.penpals.repository;

import org.mrbibz.penpals.model.Writeoff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriteoffRepository extends MongoRepository<Writeoff, String>{
}
