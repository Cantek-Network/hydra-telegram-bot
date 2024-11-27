package com.telegram.telegrambot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class TeleBotOwners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long botId;
    private String ownerId;
    private String firstName;
    private String lastName;
    private String email;
    private String telegram;
    private String twitter;
    private String facebook;
    private String whatsapp;
    private String website;
    private String description;
    private Timestamp createdAt;
}
