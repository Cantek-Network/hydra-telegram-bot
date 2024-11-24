package com.telegram.telegrambot.service;

import com.telegram.telegrambot.TelegramBotApplication;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.swing.text.html.HTML;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TelegramBotService extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            String sender = message.getFrom().getUserName();
            String senderId = message.getFrom().getId().toString();
            String channelId = message.getChat().getId().toString();
            String channelType = message.getChat().getType();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(channelId);
            SendPhoto sendPhoto = new SendPhoto();
            String text = message.getText();
            if (text.equalsIgnoreCase("/start")){
                String getStarted = "👋 Welcome to HYDRA Wallet - the next generation Telegram wallet. Create account to use crypto and do more things in the future.\n" +
                        "\n" +
                        "\uD83D\uDD10What's special?\n" +
                        "\n" +
                        "HYDRA Wallet is centerpiece for wallet with fair launch. Easy to create and use right on Telegram\n" +
                        "Next-generation telegram wallet built over Cardano blockchain. \n" +
                        "Built to bring development to Dapps and Gamefi on Cardano";
//                sendMessage.setChatId(channelId);
//                sendMessage.setText(getStarted);
                sendPhoto.setChatId(channelId);
                sendPhoto.setCaption(getStarted);
                String imagePath = "src/main/resources/image/hydra_banner.png";
                File imageFile = new File(imagePath);
                sendPhoto.setPhoto(new InputFile(imageFile, "hyra_banner"));
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> listInlineKeyboardButton = new ArrayList<>();
                List<InlineKeyboardButton> buttons = new ArrayList<>();

                InlineKeyboardButton communityButton = new InlineKeyboardButton();
                communityButton.setText("Join the community");
                String url = "https://www.youtube.com/";
                communityButton.setUrl(url);

                buttons.add(communityButton);

                InlineKeyboardButton openWalletButton = new InlineKeyboardButton();
                openWalletButton.setText("Open Wallet");
                openWalletButton.setUrl("t.me/HydraDemo_bot/HydraWallet");
                buttons.add(openWalletButton);

                listInlineKeyboardButton.add(buttons);
                inlineKeyboardMarkup.setKeyboard(listInlineKeyboardButton);

                sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
//                sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                try {
                    this.execute(sendPhoto);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "HydraDemo";
    }
    @Override
    public String getBotToken() {
        return "8188378386:AAHcYWIH9lGFaSKvfdLcpUKzTxaJplbrRM4";
    }
}
