package com.hyunho.springboot.web;

import com.hyunho.springboot.web.dto.gpt.BotRequest;
import com.hyunho.springboot.web.dto.gpt.ChatGptResponse;
import com.hyunho.springboot.service.bot.BotService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bot")
@RequiredArgsConstructor
public class BotController {

    private final BotService botService;

    @PostMapping("/send")
    public ChatGptResponse sendMessage(@RequestBody BotRequest botRequest) {
        return botService.askQuestion(botRequest);
    }
}




