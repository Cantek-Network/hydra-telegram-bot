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
            } else if (text.equalsIgnoreCase(Const.Commands.HELP)) {
                String helpMessage = "All commands are available in this chat:\n" +
                        "/start: Start bot\n" +
                        "/openwallet: Open wallet \n" +
                        "/login: Go to login\n" +
                        "/register: Go to register\n" +
                        "/send: Go to transfer ada\n" +
                        "/hydratransfer: Go to hydra transfer\n" +
                        "/games: Go to list game\n" +
                        "/nfthistory:  Go to nft histories tab\n" +
                        "/tokenhistory: Go to token histories tab\n" +
                        "/history: Go to histories tab\n" +
                        "/walletsetting:  Go to settings\n" +
                        "/help: List command function\n" +
                        "/community: Join the community";
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
