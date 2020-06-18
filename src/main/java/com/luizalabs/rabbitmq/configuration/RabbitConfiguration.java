package com.luizalabs.rabbitmq.configuration;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
  public static final String SIMPLE_QUEUE = "Simple_Queue";
  public static final String FANOUT_EXCHANGE = "fanout-exchange";
  public static final String FANOUT_QUEUE_1 = "FANOUT_QUEUE_1";
  public static final String FANOUT_QUEUE_2 = "FANOUT_QUEUE_2";
  public static final String FANOUT_QUEUE_3 = "FANOUT_QUEUE_3";
  public static final String TOPIC_EXCHANGE = "topic-exchange";
  public static final String TOPIC_QUEUE_1 = "TOPIC_QUEUE_1";
  public static final String TOPIC_QUEUE_2 = "TOPIC_QUEUE_2";
  public static final String KEY_TOPIC_QUEUE_1 = "KEY_TOPIC_QUEUE_1";
  public static final String KEY_TOPIC_QUEUE_2 = "KEY_TOPIC_QUEUE_2";

  @Value("${spring.rabbitmq.host}")
  private String host;

  @Value("${spring.rabbitmq.port}")
  private int port;

  @Bean
  public ConnectionFactory connectionFactory() {
    return new CachingConnectionFactory(host, port);
  }

  @Bean
  public AmqpAdmin amqpAdmin() {
    return new RabbitAdmin(connectionFactory());
  }

  @Bean
  public RabbitTemplate rabbitTemplate() {
    return new RabbitTemplate(connectionFactory());
  }


  // ========================================== Simple Queue =========================================================
  @Bean
  public Queue queue1() {
    return new Queue(SIMPLE_QUEUE);
  }
  // ========================================== Simple Queue =========================================================



  // ========================================== PUB / SUB =========================================================
  // Pub/Sub queue - Todas as mensagens que chegarem neste exchange, serão enviadas para todas as filas inscritas no mesmo.
  @Bean
  public FanoutExchange fanout() {
    return new FanoutExchange(FANOUT_EXCHANGE);
  }

  @Bean
  public Queue fanoutQueue1() {
    return new Queue(FANOUT_QUEUE_1);
  }

  @Bean
  public Queue fanoutQueue2() {
    return new Queue(FANOUT_QUEUE_2);
  }

  @Bean
  public Queue fanoutQueue3() {
    return new Queue(FANOUT_QUEUE_3);
  }

  @Bean
  public Binding funoutQueue1Binding() {
    return BindingBuilder.bind(fanoutQueue1()).to(fanout());
  }

  @Bean
  public Binding funoutQueue2Binding() {
    return BindingBuilder.bind(fanoutQueue2()).to(fanout());
  }

  @Bean
  public Binding funoutQueue3Binding() {
    return BindingBuilder.bind(fanoutQueue3()).to(fanout());
  }
  // ========================================== PUB / SUB =========================================================

 
  // ============================================ TOPIC ===========================================================
  // Topic queue - Cada mensagem que chegar neste exchange, será encaminha para uma ou mais filas específicas de acordo com a chave recebida
  @Bean
  public TopicExchange topicExchange() {
    return new TopicExchange(TOPIC_EXCHANGE);
  }

  @Bean
  public Queue topicQueue1() {
    return new Queue(TOPIC_QUEUE_1);
  }

  @Bean
  public Queue topicQueue2() {
    return new Queue(TOPIC_QUEUE_2);
  }

  @Bean
  public Binding topicQueue1Binding() {
    return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(KEY_TOPIC_QUEUE_1);
  }

  @Bean
  public Binding topicQueue2Binding() {
    return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(KEY_TOPIC_QUEUE_2);
  }
  // ============================================ TOPIC ===========================================================
}
