package com.burak.RabbitFirstConsumerApp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RabbitConsumer {

    private final PgRabbitTransactionRepo repo;

    public RabbitConsumer(PgRabbitTransactionRepo repo) {
        this.repo = repo;
    }

    @RabbitListener(queues = "rabbit-queue")
    public void receiveMessage( Notification notification){

        PgRabbitTransaction transaction =  repo.findByEventId(notification.getEventId()).orElseThrow();
        transaction.setReciveDate(new Date());
        transaction.setReciveCheck(true);
        repo.save(transaction);
        System.out.println("consumer : " + notification);
    }
}
