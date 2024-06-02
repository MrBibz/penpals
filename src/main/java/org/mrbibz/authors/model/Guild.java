package org.mrbibz.authors.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "guilds")
@NoArgsConstructor
public class Guild extends Recipient{

    private String name;
}
