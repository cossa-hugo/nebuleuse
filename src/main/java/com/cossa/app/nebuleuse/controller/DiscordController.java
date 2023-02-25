package com.cossa.app.nebuleuse.controller;

import com.cossa.app.nebuleuse.service.DiscordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nebuleuse-api")
public class DiscordController {

    private final DiscordService discordService;

    public DiscordController(DiscordService discordService) {
        this.discordService = discordService;
    }

    @PostMapping("/message")
    public ResponseEntity<Void> sendMessage(@RequestParam String channelId, @RequestParam String message) {
        discordService.sendMessage(channelId, message);
        return ResponseEntity.ok().build();
    }
}
