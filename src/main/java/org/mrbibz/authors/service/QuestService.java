package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import org.mrbibz.authors.model.Query;
import org.mrbibz.authors.model.Quest;
import org.mrbibz.authors.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestService {

    private final QuestRepository questRepository;

    public Quest createQuest(Quest quest) {
        Objects.requireNonNull(quest, "Quest cannot be null");
        return questRepository.save(quest);
    }

    public Optional<Quest> deleteQuest(String questId) {
        Objects.requireNonNull(questId, "Quest ID cannot be null");
        Optional<Quest> quest = questRepository.findById(questId);
        quest.ifPresent(questRepository::delete);
        return quest;
    }

    public Optional<Quest> editQuest(String questId, Quest updatedQuest) {
        Objects.requireNonNull(questId, "Quest ID cannot be null");
        Objects.requireNonNull(updatedQuest, "Updated quest cannot be null");
        Optional<Quest> quest = questRepository.findById(questId);
        if (quest.isPresent()) {
            questRepository.save(updatedQuest);
        }
        return quest;
    }
}
