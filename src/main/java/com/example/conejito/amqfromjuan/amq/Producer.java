package com.example.conejito.amqfromjuan.amq;

import com.example.conejito.amqfromjuan.model.Person;
import com.example.conejito.amqfromjuan.notification.JobCompletionNotificationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {


    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;

    @Autowired
    private AmqpTemplate amqpTemplate;




    public void produceMsg(String msg)
    {
        amqpTemplate.convertAndSend(exchange, routingKey, msg);

        log.info("Send msg = " + msg);
    }


    public void produceMsg(Person msg)
    {
        amqpTemplate.convertAndSend(exchange, routingKey, msg);

        log.info("I AM RABBIT MQ AND SOMEONE SEND SOMETHING TO OUR QUEUE " + msg);
    }
}