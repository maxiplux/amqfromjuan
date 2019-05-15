package com.example.conejito.amqfromjuan.configuration.writers;

import com.example.conejito.amqfromjuan.amq.Producer;
import com.example.conejito.amqfromjuan.model.Person;
import com.example.conejito.amqfromjuan.services.impl.PersonServices;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitBatchItemSenderWriter implements ItemWriter<Person> {
    @Autowired
    public PersonServices personServices;

    @Autowired
    Producer producer;

    public void write(List<? extends Person> people) throws Exception {
        people.forEach(person -> {
            producer.produceMsg(person);

        });
    }
}
