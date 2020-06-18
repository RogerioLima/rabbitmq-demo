package com.luizalabs.rabbitmq.simple_queue;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.luizalabs.rabbitmq.configuration.RabbitConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StartSimpleQueue {
  public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

  @Value("${enable.simple.queue.example}")
  private Boolean enableSimpleQueue;

  @Autowired
  private QueueSender queueSender;

  @Scheduled(fixedDelay = 4000)
  public void sendMessageToQueue() {
    if (!enableSimpleQueue) {
      return;
    }

    String date = sdf.format(new Date());
    System.out.println("\n========================================");
    System.out.println("sendMessageToSimpleQueue - " + date);

    queueSender.sendMessage(RabbitConfiguration.SIMPLE_QUEUE, "Message Body - " + date);
  }
}