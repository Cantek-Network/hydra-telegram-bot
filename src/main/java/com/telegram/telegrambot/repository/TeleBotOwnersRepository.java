package com.telegram.telegrambot.repository;

import com.telegram.telegrambot.entity.TeleBotOwners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeleBotOwnersRepository extends JpaRepository<TeleBotOwners, Long> {
}
