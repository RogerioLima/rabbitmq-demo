package com.luizalabs.rabbitmq.topic_queue;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.luizalabs.rabbitmq.configuration.RabbitConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StartTopic {
  private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

  @Value("${enable.topic.queue.example}")
  private Boolean enableTopic;

  @Autowired
  private TopicSender topicSender;

  @Scheduled(fixedDelay = 4000)
  public void sendMessageToTopic() {
    if (!enableTopic) {
      return;
    }

    buildAndSend("sendMessageToTopic for queue 1", RabbitConfiguration.KEY_TOPIC_QUEUE_1);
    buildAndSend("sendMessageToTopic for queue 2", RabbitConfiguration.KEY_TOPIC_QUEUE_2);
  }

  private void buildAndSend(String message, String key) {
    String date = sdf.format(new Date());
    System.out.println("========================================");
    System.out.println(message + " - " + date);

    String exchangeName = RabbitConfiguration.TOPIC_EXCHANGE;
    topicSender.sendMessage(exchangeName, key, "Message Body - " + message + " - " + date);
    System.out.println("========================================");
  }
}