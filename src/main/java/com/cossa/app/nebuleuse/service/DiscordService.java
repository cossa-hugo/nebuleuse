package com.cossa.app.nebuleuse.service;

import com.fasterxml.jackson.annotation.JacksonInject;
import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.object.entity.channel.TextChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscordService {

    private final DiscordClient discordClient;
    private final String token;

    public DiscordService(@Value("${discord.bot.token}") String token) {
        this.token = token;
        this.discordClient = DiscordClient.create(this.token);
    }

    public void sendMessage(String chanelId, String message) {
        discordClient.getChannelService().getChannel(Snowflake.of(chanelId).asLong())
                .cast(TextChannel.class)
                .flatMap(chanel -> chanel.createMessage(message))
                .block();
    }


}
