package org.mrbibz.authors.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guild_admins")
@NoArgsConstructor
public class GuildAdmin extends GuildMember {

    @ManyToOne
    private Author admin;

    public GuildAdmin (Guild guild, Author admin) {
        super(guild);
        this.admin = admin;
    }
}
