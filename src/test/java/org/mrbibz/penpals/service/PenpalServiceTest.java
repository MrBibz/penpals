package org.mrbibz.penpals.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mrbibz.penpals.model.Penpal;
import org.mrbibz.penpals.model.Relationship;
import org.mrbibz.penpals.repository.PenpalRepository;
import org.mrbibz.penpals.repository.RelationshipRepository;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PenpalServiceTest {

    @Mock
    private PenpalRepository penpalRepository;

    @Mock
    private RelationshipRepository relationshipRepository;

    @InjectMocks
    private PenpalService penpalService;

    private Penpal penpal1;

    @BeforeEach
    public void setUp() {
        penpal1 = new Penpal();

        when(penpalRepository.save(penpal1)).thenReturn(penpal1);

        penpalService.createPenpal(penpal1);
    }

    @Test
    public void createPenpalTest() {
        verify(penpalRepository, times(1)).save(penpal1);
    }

    @Test
    public void addPenpalTest() {
        Penpal penpal2 = new Penpal();
        Relationship relationship = new Relationship(penpal1, penpal2);

        when(penpalRepository.save(penpal2)).thenReturn(penpal2);
        when(relationshipRepository.save(relationship)).thenReturn(relationship);

        penpalService.addPenpal(penpal1, penpal2);

        verify(penpalRepository, times(1)).save(penpal2);
        verify(relationshipRepository, times(1)).save(relationship);
    }
}
