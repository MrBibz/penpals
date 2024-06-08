package org.mrbibz.authors.repository;

import org.mrbibz.authors.model.Guild;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRepository extends MongoRepository<Guild, String>{
}
