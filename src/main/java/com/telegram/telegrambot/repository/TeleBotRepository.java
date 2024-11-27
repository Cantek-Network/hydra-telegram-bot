package com.telegram.telegrambot.repository;

import com.telegram.telegrambot.entity.TeleBot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TeleBotRepository extends JpaRepository<TeleBot, Long> {

    Optional<TeleBot> findById(Long id);

    @Query(value = "select * FROM tele_bot where bot_name = :name", nativeQuery = true)
    TeleBot findTeleBotByBotName(String name);
}
