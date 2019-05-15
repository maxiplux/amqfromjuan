package com.example.conejito.amqfromjuan.services;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> findAll();

    T save(T object);

    Optional<T> findOne(String id);

    void delete(String id);
}