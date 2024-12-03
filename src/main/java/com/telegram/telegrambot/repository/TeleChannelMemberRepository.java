package com.telegram.telegrambot.repository;

import com.telegram.telegrambot.entity.TeleChannelMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeleChannelMemberRepository extends JpaRepository<TeleChannelMember, Long> {
}
