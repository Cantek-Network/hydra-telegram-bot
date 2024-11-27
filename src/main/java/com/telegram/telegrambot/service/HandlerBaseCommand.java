package com.telegram.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandlerBaseCommand {
    @Autowired
    private HandleStartCommand handleStartCommand;

    public void processStartCommand(TelegramBotService telegramBotService, String chatId) {
        handleStartCommand.processStartCommand(telegramBotService, chatId);
    }
}
