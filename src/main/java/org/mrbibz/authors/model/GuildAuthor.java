package org.mrbibz.authors.model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guild_authors")
public class GuildAuthor  extends GuildMember {

    @ManyToOne
    private Author author;
}
