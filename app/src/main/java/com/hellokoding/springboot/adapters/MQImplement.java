package com.hellokoding.springboot.adapters;
import com.hellokoding.springboot.domain.CustomMessage;
import com.hellokoding.springboot.domain.MessageQueue;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MQImplement implements MessageQueue {
    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public MQImplement(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }


    public void send(CustomMessage customMessage) {
        this.amqpTemplate
                .convertAndSend(GlobalConfig.DISTRIBUTION_EXCHANGE, "", customMessage.getText());
    }
}
