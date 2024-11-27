package com.telegram.telegrambot.utils;

import com.telegram.telegrambot.entity.TeleAppUrl;
import com.telegram.telegrambot.entity.TeleBot;
import com.telegram.telegrambot.repository.TeleAppUrlRepository;
import com.telegram.telegrambot.repository.TeleBotRepository;
import com.telegram.telegrambot.service.HandlerBaseCommand;
import com.telegram.telegrambot.service.TelegramBotService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;


@Component
public class TeleBotUtil {
    private HandlerBaseCommand handlerBaseCommand;
    private TeleBotRepository teleBotRepository;
    private TeleAppUrlRepository teleAppUrlRepository;
    public TeleBotUtil(TeleBotRepository teleBotRepository, HandlerBaseCommand handlerBaseCommand, TeleAppUrlRepository teleAppUrlRepository) {
        this.teleBotRepository = teleBotRepository;
        this.handlerBaseCommand = handlerBaseCommand;
        this.teleAppUrlRepository = teleAppUrlRepository;

        TeleBot teleBot = teleBotRepository.findTeleBotByBotName("HydraDemo");
        List<TeleAppUrl> teleAppUrls = teleAppUrlRepository.findAll();
        TelegramBotService telegramBotService = new TelegramBotService(handlerBaseCommand, teleBot, teleAppUrls);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBotService);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
