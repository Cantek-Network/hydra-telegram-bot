package com.telegram.telegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class HandleOpenWalletCommand {
    public void handleOpenWalletCommand(TelegramBotService telegramBotService, String chatId, String url) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        String openWalletMessage = "You can open your wallet using this link " + url;
        sendMessage.setText(openWalletMessage);
        try {
            telegramBotService.execute(sendMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
