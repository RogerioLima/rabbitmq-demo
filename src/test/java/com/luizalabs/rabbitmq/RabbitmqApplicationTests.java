package com.luizalabs.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class RabbitmqApplicationTests {

  @MockBean
  private ConnectionFactory connectionFactory;

  @MockBean
  private AmqpAdmin amqpAdmin;

	@Test
	void contextLoads() {
	}

}
