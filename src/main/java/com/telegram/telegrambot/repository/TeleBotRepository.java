package com.telegram.telegrambot.repository;

import com.telegram.telegrambot.entity.TeleBot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeleBotRepository extends JpaRepository<TeleBot, Long> {
    TeleBot findTeleBotByStatus(String status);
}
