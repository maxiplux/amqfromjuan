package com.example.conejito.amqfromjuan.repository;

import com.example.conejito.amqfromjuan.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends MongoRepository<Person, String> {


}