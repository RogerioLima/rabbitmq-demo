package com.luizalabs.rabbitmq.topic_queue;

import com.luizalabs.rabbitmq.configuration.RabbitConfiguration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {
  @RabbitListener(queues = { RabbitConfiguration.TOPIC_QUEUE_1 })
  public void listenerTopicQueue1(@Payload String body) {
    System.out.println("Message received from " + RabbitConfiguration.TOPIC_QUEUE_1);
    System.out.println(body);
    System.out.println("========================================");
  }

  @RabbitListener(queues = { RabbitConfiguration.TOPIC_QUEUE_2 })
  public void listenerTopicQueue2(@Payload String body) {
    System.out.println("Message received from " + RabbitConfiguration.TOPIC_QUEUE_2);
    System.out.println(body);
    System.out.println("========================================");
  }
}