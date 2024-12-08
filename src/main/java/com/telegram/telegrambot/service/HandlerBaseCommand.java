package com.telegram.telegrambot.service;

import com.telegram.telegrambot.entity.TeleBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandlerBaseCommand {
    @Autowired
    private HandleStartCommand handleStartCommand;

    public void processStartCommand(TelegramBotService telegramBotService, TeleBot teleBot, String chatId) {
        handleStartCommand.processStartCommand(telegramBotService, teleBot, chatId);
    }
}
