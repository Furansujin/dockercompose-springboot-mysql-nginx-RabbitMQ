package com.hellokoding.springboot;


import com.hellokoding.springboot.domain.Greeting;
import com.hellokoding.springboot.domain.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/all")
public class controllerTest {

    @Autowired
    private GreetingRepository greetingRepository;


    @RequestMapping(value = "/liste",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Set<Greeting> getAll() {
        return greetingRepository.all();
    }

}
