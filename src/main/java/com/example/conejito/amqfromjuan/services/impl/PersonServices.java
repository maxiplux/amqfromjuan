package com.example.conejito.amqfromjuan.services.impl;

import com.example.conejito.amqfromjuan.model.Person;
import com.example.conejito.amqfromjuan.repository.PersonRepository;
import com.example.conejito.amqfromjuan.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServices implements IService<Person> {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Person save(Person object) {
        return this.personRepository.save(object);
    }

    @Override
    public Optional<Person> findOne(String id) {
        return this.personRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        this.personRepository.deleteById(id);

    }
}
