package com.telegram.telegrambot.repository;

import com.telegram.telegrambot.entity.TeleBotChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeleBotChannelRepository extends JpaRepository<TeleBotChannel, Long> {
}
