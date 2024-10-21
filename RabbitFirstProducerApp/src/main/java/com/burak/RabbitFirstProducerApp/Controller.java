package com.burak.RabbitFirstProducerApp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rabbit")
public class Controller {
      private final Producer producer;

    public Controller(Producer producer) {
        this.producer = producer;
    }


    @GetMapping("/test")
    public String test(){

        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("app başladı");
                Notification notification = new Notification();
                notification.setId(1001);
                notification.setEventId(UUID.randomUUID().toString());
                notification.setDate(new Date());
                producer.sendMessage(notification);
            }
        };
        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(task, 1000l,100l);


        return "ok";
    }
}
