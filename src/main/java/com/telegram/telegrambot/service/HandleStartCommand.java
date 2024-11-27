package com.telegram.telegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class HandleStartCommand {
    public void processStartCommand(TelegramBotService telegramBotService,String chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        String getStarted = "👋 Welcome to HYDRA Wallet - the next generation Telegram wallet. Create account to use crypto and do more things in the future.\n" +
                "\n" +
                "\uD83D\uDD10What's special?\n" +
                "\n" +
                "HYDRA Wallet is centerpiece for wallet with fair launch. Easy to create and use right on Telegram\n" +
                "Next-generation telegram wallet built over Cardano blockchain. \n" +
                "Built to bring development to Dapps and Gamefi on Cardano";
        sendPhoto.setChatId(chatId);
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
        try {
            telegramBotService.execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
