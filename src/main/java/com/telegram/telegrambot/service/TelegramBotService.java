package com.telegram.telegrambot.service;

import com.telegram.telegrambot.common.Const;
import com.telegram.telegrambot.entity.TeleAppUrl;
import com.telegram.telegrambot.entity.TeleBot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class TelegramBotService extends TelegramLongPollingBot {
    private final HandlerBaseCommand handlerBaseCommand;

    public TeleBot telegramBot;
    public List<TeleAppUrl> teleAppUrls;

    public TelegramBotService(HandlerBaseCommand handlerBaseCommand, TeleBot telegramBot, List<TeleAppUrl> teleAppUrls) {
        this.handlerBaseCommand = handlerBaseCommand;
        this.telegramBot = telegramBot;
        this.teleAppUrls = teleAppUrls;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            String chatId = message.getChat().getId().toString();
            String text = message.getText();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            if (text.equalsIgnoreCase(Const.Commands.START)){
                handlerBaseCommand.processStartCommand(this, chatId);
            } else {
                for (TeleAppUrl teleAppUrl : teleAppUrls){
                    if (text.equalsIgnoreCase(teleAppUrl.getCommand())){
                        String commandMessage = "You can open " + teleAppUrl.getDescription() + " using this link " + teleAppUrl.getUrl();
                        sendMessage.setText(commandMessage);
                        try{
                            this.execute(sendMessage);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return telegramBot.getBotName();
    }
    @Override
    public String getBotToken() {
        return telegramBot.getToken();
    }
}
