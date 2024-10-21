package com.burak.RabbitFirstProducerApp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@SpringBootApplication
public class RabbitFirstProducerAppApplication  {


    public static void main(String[] args) throws Exception {
		SpringApplication.run(RabbitFirstProducerAppApplication.class, args);

	}


}
