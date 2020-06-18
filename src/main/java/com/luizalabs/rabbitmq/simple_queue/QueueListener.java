package com.luizalabs.rabbitmq.simple_queue;

import com.luizalabs.rabbitmq.configuration.RabbitConfiguration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

  /**
   * Recebe os dados vindos da fila 1 e aciona a classe responsável por processar estes dados.
   * @param queueMessage - Queue Message
   */
  @RabbitListener(queues = { RabbitConfiguration.SIMPLE_QUEUE })
  public void listenerQueue1(@Payload String queueMessage) {
    System.out.println("\n=== Data received from queue Simple_Queue ==");
    System.out.println(queueMessage);
    System.out.println("========================================");
  }
}
