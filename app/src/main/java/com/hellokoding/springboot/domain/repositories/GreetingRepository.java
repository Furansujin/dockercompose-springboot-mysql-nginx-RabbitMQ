package com.hellokoding.springboot.domain.repositories;

import com.hellokoding.springboot.domain.Greeting;

import java.util.Set;

public interface GreetingRepository {

    Set<Greeting> all();

    void add(Greeting greeting);
}
