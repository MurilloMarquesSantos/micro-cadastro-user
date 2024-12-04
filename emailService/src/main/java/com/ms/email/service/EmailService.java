package com.ms.email.service;

import com.ms.email.domain.Email;
import com.ms.email.domain.dto.EmailDto;
import com.ms.email.repositories.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    public void sendEmail(Email email) {

        email.setSendDateEmail(LocalDateTime.now());

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email.getEmailTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getText());

            mailSender.send(message);
            emailRepository.save(email);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }



    }
}
