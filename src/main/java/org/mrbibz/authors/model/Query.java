package org.mrbibz.authors.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document("messages")
@NoArgsConstructor
@Setter
@Getter
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne
    private Recipient recipient;

    @OneToOne
    private Author sender;
}
