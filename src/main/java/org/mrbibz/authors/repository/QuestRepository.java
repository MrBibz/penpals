package org.mrbibz.authors.repository;

import org.mrbibz.authors.model.Quest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends MongoRepository<Quest, String>{
}
