package com.example.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//开启基于注解的rabbitmq模式
@EnableRabbit
@SpringBootApplication
public class Spring02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring02AmqpApplication.class, args);
    }

}
