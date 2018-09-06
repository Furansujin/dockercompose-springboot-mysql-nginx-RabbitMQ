package com.hellokoding.springboot;


import com.hellokoding.springboot.adapters.mq.GlobalConfig;
import com.hellokoding.springboot.adapters.mq.rabbitproducer.Message;
import com.hellokoding.springboot.domain.Greeting;
import com.hellokoding.springboot.domain.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/all")
public class controllerTest {

    @Autowired
    private GreetingRepository greetingRepository;


    @Autowired
    private  test test1;

    @RequestMapping(value = "/liste",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Set<Greeting> getAll() throws InterruptedException {

        return greetingRepository.all();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    String add(@RequestBody Message message) throws Exception {
        test1.getAmqpTemplate()
                .convertAndSend(GlobalConfig.DISTRIBUTION_EXCHANGE, "", message.getMessageBody());

        return "Received message: " + message.getMessageType() + "::" + message.getMessageBody();

    }

}
