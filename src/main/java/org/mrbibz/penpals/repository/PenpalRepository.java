package org.mrbibz.penpals.repository;

import org.mrbibz.penpals.model.Penpal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenpalRepository extends MongoRepository<Penpal, String>{
}
