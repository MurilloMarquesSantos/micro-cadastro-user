package com.ms.user.producer;

import com.ms.user.domain.User;
import com.ms.user.domain.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.exchange.name}")
    private String exchangeName;

    public void publishMessage(User user) {
        EmailDto emailDto = new EmailDto();
        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("CADASTRO");
        emailDto.setText(user.getName() + ", Bem vindo(a)!\nCadastro realizado com sucesso!");

        rabbitTemplate.convertAndSend(exchangeName,"", emailDto);
    }


}
