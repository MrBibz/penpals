package org.mrbibz.authors.model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "guild_authors")
public class GuildAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    private Guild guild;

    @ManyToOne
    private Author author;
}
