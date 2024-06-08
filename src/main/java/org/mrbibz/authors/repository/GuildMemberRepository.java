package org.mrbibz.authors.repository;

import org.mrbibz.authors.model.GuildMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildMemberRepository extends MongoRepository<GuildMember, String> {
}
