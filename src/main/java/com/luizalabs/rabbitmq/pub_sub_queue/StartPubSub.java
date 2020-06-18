package com.luizalabs.rabbitmq.pub_sub_queue;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.luizalabs.rabbitmq.configuration.RabbitConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StartPubSub {
  private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

  @Value("${enable.pubsub.queue.example}")
  private Boolean enablePubSub;

  @Autowired
  private PubSubSender pubSubSender;

  @Scheduled(fixedDelay = 4000)
  public void sendMessageToPubSub() {
    if (!enablePubSub) {
      return;
    }

    String date = sdf.format(new Date());
    System.out.println("\n========================================");
    System.out.println("sendMessageToPubSub - " + date);

    String exchangeName = RabbitConfiguration.FANOUT_EXCHANGE;
    pubSubSender.sendMessage(exchangeName, "", "Message Body - " + date);
    System.out.println("\n========================================");
  }
}