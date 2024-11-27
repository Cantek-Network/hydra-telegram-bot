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
public class TeleBotChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long teleChannelId;
    private String type;
    private String name;
    private long numOfMember;
    private String status;
    private Timestamp createdAt;
    private long createdBy;
    private Timestamp updatedAt;
    private long updatedBy;
}
