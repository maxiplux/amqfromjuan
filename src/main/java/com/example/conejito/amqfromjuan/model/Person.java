package com.example.conejito.amqfromjuan.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "persons")
@Data
@NoArgsConstructor
// Dear juan always implement serializeable , for example to work with amq
public class Person implements Serializable {
    @Id
    private String commentId;
    private String lastName;
    private String firstName;
    private long seq;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
