package org.mrbibz.authors.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class GuildMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    private Guild guild;

    public GuildMember (Guild guild) {
        this.guild = guild;
    }
}
