package com.telegram.telegrambot.utils;

import com.telegram.telegrambot.common.Const;
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

    public TeleBotUtil(TeleBotRepository teleBotRepository, HandlerBaseCommand handlerBaseCommand, TeleAppUrlRepository teleAppUrlRepository) {

        TeleBot teleBot = teleBotRepository.findTeleBotByStatus(Const.Status.ACTIVE);
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
