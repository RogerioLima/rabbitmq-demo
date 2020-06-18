package com.luizalabs.rabbitmq.pub_sub_queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PubSubSender {
  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void sendMessage(String exchange, String routingKey, String message) {
    rabbitTemplate.convertAndSend(exchange, routingKey, message);
  }
}