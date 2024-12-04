package com.ms.email.consumer;

import com.ms.email.domain.Email;
import com.ms.email.domain.dto.EmailDto;
import com.ms.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmail(@Payload EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailService.sendEmail(email);

    }

}
