package com.ms.logs.consumer;

import com.ms.logs.dto.EmailDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Log4j2
public class LogConsumer {

    @RabbitListener(queues = "${broker.queue.log.name}")
    public void listenQueue(@Payload EmailDto emailDto) {
        UUID userId = emailDto.getUserId();
        String emailTo = emailDto.getEmailTo();
        log.info("New user created! UUID:\"{}\" Email: \"{}\"", userId, emailTo);

    }

}
