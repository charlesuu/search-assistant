package com.hyunho.springboot.service.bot;


import com.hyunho.springboot.web.dto.gpt.BotRequest;
import com.hyunho.springboot.web.dto.gpt.ChatGptResponse;

public interface BotService {

    ChatGptResponse askQuestion(BotRequest botRequest);
}

