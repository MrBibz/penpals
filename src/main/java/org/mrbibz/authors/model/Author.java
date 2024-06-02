package org.mrbibz.authors.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.mrbibz.authors.service.dto.AuthorDto;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "authors")
@NoArgsConstructor
public class Author extends Recipient {

    private String username;

    private String characterClass;

    private String password;

    private String email;

    public Author(String username, String characterClass, String password, String email) {
        this.username = username;
        this.characterClass = characterClass;
        this.password = password;
        this.email = email;
    }

    AuthorDto toDto() {
        return new AuthorDto(id, username, characterClass, email);
    }
}
