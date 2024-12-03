package com.telegram.telegrambot.repository;

import com.telegram.telegrambot.entity.TeleBotOwners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeleBotOwnersRepository extends JpaRepository<TeleBotOwners, Long> {
}
