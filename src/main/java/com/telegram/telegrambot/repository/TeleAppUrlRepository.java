package com.telegram.telegrambot.repository;

import com.telegram.telegrambot.entity.TeleAppUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeleAppUrlRepository extends JpaRepository<TeleAppUrl, Long> {
    @Query(value = "SELECT * FROM tele_app_url", nativeQuery = true)
    List<TeleAppUrl> findAll();
}
