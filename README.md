# Rabbit MQ Demo

>Demo project for RabbitMQ

## Requirements

You'll need two things to start:

    java 11
    maven


## Quickstart

>to download project:

    git clone https://github.com/RogerioLima/rabbitmq-demo.git

>install the project dependencies:

    mvn clean install

>Add the environment variables:

    spring.rabbitmq.host=${RABBITMQ_HOST}
    spring.rabbitmq.port=${RABBITMQ.PORT}
    spring.rabbitmq.username=${RABBITMQ_USERNAME}
    spring.rabbitmq.password=${RABBITMQ_PASSWORD}

    enable.simple.queue.example=true
    enable.pubsub.queue.example=false
    enable.topic.queue.example=false

>run project:

    mvn spring-boot:run
    
>run tests:

    mvn clean test
