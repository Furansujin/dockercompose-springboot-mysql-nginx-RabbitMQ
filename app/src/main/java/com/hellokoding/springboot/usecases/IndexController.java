package com.hellokoding.springboot.usecases;


import com.hellokoding.springboot.domain.Greeting;
import com.hellokoding.springboot.domain.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        final Model greeting = model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        greetingRepository.add(greeting);
        return "result";
    }


}
