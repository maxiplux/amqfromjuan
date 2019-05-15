package com.example.conejito.amqfromjuan.amq;

import com.example.conejito.amqfromjuan.model.Person;
import com.example.conejito.amqfromjuan.procesor.PersonItemProcessor;
import com.example.conejito.amqfromjuan.services.impl.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    public PersonServices personServices;

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);



    @RabbitListener(queues="${jsa.rabbitmq.queue}")
    //https://www.youtube.com/watch?time_continue=188&v=QS6Glk74oYg
    //https://grokonez.com/java-integration/distributed-system/create-spring-rabbitmq-producerconsumer-application-springboot
    public void recievedMessage(Person msg) {
        log.info("I am Rabbit Mq, I am reading my queue and I found : " + msg);
        personServices.save(msg);
        log.info("I'm taking this information and put on mongodb   " + msg);
    }
}