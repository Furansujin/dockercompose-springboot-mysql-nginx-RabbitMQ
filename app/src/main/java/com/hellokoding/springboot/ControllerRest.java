package com.hellokoding.springboot;


import com.hellokoding.springboot.adapters.MQImplement;
import com.hellokoding.springboot.adapters.GlobalConfig;
import com.hellokoding.springboot.domain.CustomMessage;
import com.hellokoding.springboot.domain.Greeting;
import com.hellokoding.springboot.domain.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/all")
public class ControllerRest {

    @Autowired
    private GreetingRepository greetingRepository;


    @Autowired
    private MQImplement mqImplement;

    @RequestMapping(value = "/liste",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Set<Greeting> getAll() throws InterruptedException {

        return greetingRepository.all();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    String add(@RequestBody CustomMessage message) throws Exception {
        mqImplement.send(message);
        return "Received message: " + message.getText();

    }

}
