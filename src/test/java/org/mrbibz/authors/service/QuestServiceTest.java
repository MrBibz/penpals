package org.mrbibz.authors.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mrbibz.authors.model.Quest;
import org.mrbibz.authors.repository.QuestRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestServiceTest {

    @Mock
    private QuestRepository questRepository;

    @InjectMocks
    private QuestService questService;

    private Quest quest;

    @BeforeEach
    public void setUp() {
        quest = new Quest();

        when(questRepository.save(any(Quest.class))).thenReturn(any(Quest.class));

        questService.createQuest(quest);
    }

    @Test
    public void createQuestTest() {
        verify(questRepository, times(1)).save(any(Quest.class));
    }

    @Test
    public void updateQuestTest() {

        when(questRepository.save(any(Quest.class))).thenReturn(any(Quest.class));
    }
}
