package com.hellokoding.springboot.adapters.mq.rabbitproducer;

import com.hellokoding.springboot.adapters.mq.GlobalConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    public final static String routingKey = "device-sample";

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(Message message) throws Exception {
        System.out.println("Sending message..."+message.getMessageType()+"   "+message.getMessageBody());
        rabbitTemplate.convertAndSend(GlobalConfig.DISTRIBUTION_EXCHANGE, message.getMessageType(), message.getMessageBody());
    }

}
