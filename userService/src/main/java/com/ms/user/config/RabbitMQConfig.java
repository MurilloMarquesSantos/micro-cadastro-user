package com.ms.user.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.email.name}")
    private String emailQueueName;

    @Value("${broker.queue.log.name}")
    private String logQueue;

    @Value("${broker.exchange.name}")
    private String exchangeName;

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(exchangeName);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueueName);
    }

    @Bean
    public Queue logQueue() {
        return new Queue(logQueue);
    }

    @Bean
    public Binding emailQueueBinding(FanoutExchange fanoutExchange, Queue emailQueue) {
        return BindingBuilder.bind(emailQueue).to(fanoutExchange);
    }

    @Bean
    public Binding logQueueBinding(FanoutExchange fanoutExchange,@Qualifier("logQueue") Queue logQueueName) {
        return BindingBuilder.bind(logQueueName).to(fanoutExchange);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
