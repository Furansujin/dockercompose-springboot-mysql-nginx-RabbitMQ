package com.hellokoding.springboot.adapters;

import com.hellokoding.springboot.domain.Greeting;
import com.hellokoding.springboot.domain.repositories.GreetingRepository;

import java.util.LinkedHashSet;
import java.util.Set;

public class InMemoryGreetingRepository implements GreetingRepository {

    private Set<Greeting> greetings = new LinkedHashSet<>();

    public Set<Greeting> all() {
        return greetings;
    }

    @Override
    public void add(Greeting greeting) {
        greetings.add(greeting);

    }
}
