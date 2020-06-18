package com.luizalabs.rabbitmq.pub_sub_queue;

import com.luizalabs.rabbitmq.configuration.RabbitConfiguration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PubSubListener {
  @RabbitListener(queues = { RabbitConfiguration.FANOUT_QUEUE_1 })
  public void listenerFunoutQueue1(@Payload String body) {
    System.out.println("Message received from " + RabbitConfiguration.FANOUT_QUEUE_1);
    System.out.println(body);
    System.out.println("========================================");
  }

  @RabbitListener(queues = { RabbitConfiguration.FANOUT_QUEUE_2 })
  public void listenerFunoutQueue2(@Payload String body) {
    System.out.println("Message received from " + RabbitConfiguration.FANOUT_QUEUE_2);
    System.out.println(body);
    System.out.println("========================================");
  }

  @RabbitListener(queues = { RabbitConfiguration.FANOUT_QUEUE_3 })
  public void listenerFunoutQueue3(@Payload String body) {
    System.out.println("Message received from " + RabbitConfiguration.FANOUT_QUEUE_3);
    System.out.println(body);
    System.out.println("========================================");
  }
}