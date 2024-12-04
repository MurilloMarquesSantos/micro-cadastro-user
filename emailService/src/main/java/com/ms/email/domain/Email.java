package com.ms.email.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "TB_EMAILS")
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;

    private UUID userId;

    private String emailTo;

    private String subject;

    private String text;

    private LocalDateTime sendDateEmail;
}
