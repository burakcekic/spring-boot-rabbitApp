package com.burak.RabbitFirstProducerApp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;
     @Value("${rabbit.routing.name}")
    private String routingName;
    @Value("${rabbit.exchange.name}")
    private String exchangeName;

    @Value("${rabbit.queue.name}")
    private String queueName;

    private final PgRabbitTransactionRepo repo;


    public Producer(RabbitTemplate rabbitTemplate, PgRabbitTransactionRepo repo) {
        this.rabbitTemplate = rabbitTemplate;
        this.repo = repo;
    }


    public void sendMessage(Notification notification){

        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
        System.out.println("event gitti");
        PgRabbitTransaction transaction = new PgRabbitTransaction();
        transaction.setQueueName(queueName);
        transaction.setEventId(notification.getEventId());
        transaction.setEventPayload(notification.toString());
        transaction.setSendDate(new Date());
        transaction.setSendCheck(true);

        repo.save(transaction);

    }
}
