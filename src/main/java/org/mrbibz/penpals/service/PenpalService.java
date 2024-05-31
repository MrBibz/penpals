package org.mrbibz.penpals.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mrbibz.penpals.model.Penpal;
import org.mrbibz.penpals.model.Post;
import org.mrbibz.penpals.model.Relationship;
import org.mrbibz.penpals.model.Writeoff;
import org.mrbibz.penpals.repository.PenpalRepository;
import org.mrbibz.penpals.repository.PostRepository;
import org.mrbibz.penpals.repository.RelationshipRepository;
import org.mrbibz.penpals.repository.WriteoffRepository;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class PenpalService {

    private PenpalRepository penpalRepository;

    private RelationshipRepository relationshipRepository;

    private PostRepository postRepository;

    private WriteoffRepository writeoffRepository;

    public Penpal createPenpal(Penpal penpal) {
        Objects.requireNonNull(penpal);
        return penpalRepository.save(penpal);
    }

    public Relationship addPenpal(Penpal penpal1, Penpal penpal2) {
        Objects.requireNonNull(penpal1);
        Objects.requireNonNull(penpal2);
        return relationshipRepository.save(new Relationship(penpal1, penpal2));
    }

    public Post createPost(Post post) {
        Objects.requireNonNull(post);
        return postRepository.save(post);
    }

    public Writeoff createWriteoff(Writeoff writeoff) {
        Objects.requireNonNull(writeoff);
        return writeoffRepository.save(writeoff);
    }
}
