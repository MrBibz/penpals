package org.mrbibz.authors.service;

import lombok.AllArgsConstructor;
import org.mrbibz.authors.model.Author;
import org.mrbibz.authors.model.Guild;
import org.mrbibz.authors.model.GuildAdmin;
import org.mrbibz.authors.model.GuildMember;
import org.mrbibz.authors.repository.GuildMemberRepository;
import org.mrbibz.authors.repository.GuildRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class GuildService {

    private final GuildRepository guildRepository;

    private final GuildMemberRepository guildMemberRepository;

    public Guild createGuild(Guild guild) {
        Objects.requireNonNull(guild, "Guild cannot be null");
        return guildRepository.save(guild);
    }

    public Guild editGuild(String guildId, Guild updatedGuild) {
        Objects.requireNonNull(guildId, "Guild ID cannot be null");
        Objects.requireNonNull(updatedGuild, "Updated guild cannot be null");
        Guild guild = guildRepository.findById(guildId).orElse(null);
        if (guild != null) {
            guildRepository.save(updatedGuild);
        }
        return guild;
    }

    public Guild deleteGuild(String guildId) {
        Objects.requireNonNull(guildId, "Guild ID cannot be null");
        Guild guild = guildRepository.findById(guildId).orElse(null);
        if (guild != null) {
            guildRepository.deleteById(guildId);
        }
        return guild;
    }

    public GuildMember promoteMember(Guild guild, Author member) {
        Objects.requireNonNull(guild, "Guild cannot be null");
        Objects.requireNonNull(member, "Member cannot be null");
        GuildMember guildadmin = new GuildAdmin(guild, member);
        guildMemberRepository.save(guildadmin);
        return guildadmin;
    }
}
