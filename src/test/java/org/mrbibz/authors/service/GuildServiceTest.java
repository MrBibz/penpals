package org.mrbibz.authors.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mrbibz.authors.model.Author;
import org.mrbibz.authors.model.Guild;
import org.mrbibz.authors.model.GuildMember;
import org.mrbibz.authors.repository.GuildMemberRepository;
import org.mrbibz.authors.repository.GuildRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GuildServiceTest {

    @Mock
    private GuildRepository guildRepository;

    @Mock
    private GuildMemberRepository guildMemberRepository;

    @InjectMocks
    private GuildService guildService;

    private Guild guild;

    @BeforeEach
    public void setUp() {
        guild = new Guild();

        when(guildRepository.save(any(Guild.class))).thenReturn(any(Guild.class));

        guildService.createGuild(guild);
    }

    @Test
    public void createGuildTest() {
        verify(guildRepository, times(1)).save(guild);
    }

    @Test
    public void editGuildTest() {
        Guild updatedGuild = new Guild();
        guild.setId("guildId");

        when(guildRepository.findById(guild.getId())).thenReturn(Optional.of(guild));
        when(guildRepository.save(any(Guild.class))).thenReturn(updatedGuild);

        guildService.editGuild(guild.getId(), updatedGuild);

        verify(guildRepository, times(1)).save(updatedGuild);
    }

    @Test
    public void deleteGuildTest() {
        guild.setId("guildId");

        when(guildRepository.findById(guild.getId())).thenReturn(Optional.of(guild));

        guildService.deleteGuild(guild.getId());

        verify(guildRepository, times(1)).deleteById(guild.getId());
    }

    @Test
    public void promoteMemberTest() {
        Author guildMember = new Author();

        when(guildMemberRepository.save(any(GuildMember.class))).thenReturn(new GuildMember());

        guildService.promoteMember(guild, guildMember);

        verify(guildMemberRepository, times(1)).save(any(GuildMember.class));
    }
}
