package org.mrbibz.authors.model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "guild_admins")
public class GuildAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    private Guild guild;

    @ManyToOne
    private Author admin;
}
